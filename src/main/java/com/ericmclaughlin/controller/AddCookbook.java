package com.ericmclaughlin.controller;

import com.ericmclaughlin.api.ItemsItem;
import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.BookApiDao;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet that works with the jsps to add a cookbook to the database.
 * @author eemclaughlin
 * @version 2.0 11-19-22
 */
@WebServlet("/addCookbook")
public class AddCookbook extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * DoGet method that gets an ISBN and additional notes from a jsp.  It then searches
     * Google Books for the book info related to the ISBN.  It then adds the info to the
     * database and sends the user to the confirmation page.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for Cookbooks.
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        // Get information entered from the form
        String isbn = req.getParameter("isbn");
        String cookbookNotes = req.getParameter("cookbookNotes");

        logger.debug("The user entered ISBN: " + isbn);
        // Remove the dashes from the ISBN.
        isbn = removeDashes(isbn);
        logger.debug("The isbn without dashes is: " + isbn);

        // Instantiate a new Google Books dao to get the info out of Google Books
        BookApiDao dao = new BookApiDao();

        // Declare the variables for the cookbook
        int cookbookId = 0;
        String title = null;
        String author = null;
        String publisher = null;
        String publishedDate = null;
        String description = null;
        String isdnTen = null;
        String isdnThirteen = null;
        int pageCount = 0;
        String language = null;
        String smallImageLink = null;
        String mediumImageLink = null;

        // This was user entered data, so it does not start as null and is not used with
        // the Google Books API.
        String notes = cookbookNotes;

        // Get data from the Google Books API and populate into variables.
        for (ItemsItem item : dao.getResponseInfo(isbn).getItems()) {

            title = item.getVolumeInfo().getTitle();
            publisher = item.getVolumeInfo().getPublisher();
            publishedDate = item.getVolumeInfo().getPublishedDate() + "-01";
            description = item.getVolumeInfo().getDescription();
            pageCount = item.getVolumeInfo().getPageCount();
            language = item.getVolumeInfo().getLanguage();
            smallImageLink = item.getVolumeInfo().getImageLinks().getSmallThumbnail();
            mediumImageLink = item.getVolumeInfo().getImageLinks().getThumbnail();

            // For each author in array at second half of "for"...
            for(String arrayAuthor : item.getVolumeInfo().getAuthors()) {
                author = arrayAuthor;
            }

            // Get ISBN 10 and 13 from the data returned from Google Books
            for (int i = 0; i < item.getVolumeInfo().getIndustryIdentifiers().size(); i++) {
                if (item.getVolumeInfo().getIndustryIdentifiers().get(i).getType().equals("ISBN_10")) {
                    isdnTen = item.getVolumeInfo().getIndustryIdentifiers().get(i).getIdentifier();
                } else if (item.getVolumeInfo().getIndustryIdentifiers().get(i).getType().equals("ISBN_13")) {
                    isdnThirteen = item.getVolumeInfo().getIndustryIdentifiers().get(i).getIdentifier();
                }
            }
        }

        // Creates a map and adds the cookbook information to it (except for ID)
        HashMap<String, String> newCookbookParts = new HashMap();
        newCookbookParts.put("cbTitle", title);
        newCookbookParts.put("cbAuthor", author);
        newCookbookParts.put("cbPublisher", publisher);
        newCookbookParts.put("cbPublishedDate", publishedDate);
        newCookbookParts.put("cbDescription", description);
        newCookbookParts.put("cbIsdnTen", isdnTen);
        newCookbookParts.put("cbIsdnThirteen", isdnThirteen);
        newCookbookParts.put("cbPageCount", String.valueOf(pageCount));
        newCookbookParts.put("cbLanguage", language);
        newCookbookParts.put("cbSmallImageLink", smallImageLink);
        newCookbookParts.put("cbNotes", cookbookNotes);

        logger.debug("The new cookbook parts except for ID are: " + newCookbookParts);

        // Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        logger.debug("The user's username is: " + loggedInUser.getUserName());

        // Create a new cookbook object with all the collected info and insert into the database.
        Cookbook cookbook = new Cookbook(title, author, publisher, publishedDate,
                description, isdnTen, isdnThirteen, pageCount, language, smallImageLink,
                mediumImageLink, notes, loggedInUser);
        cookbookId = cookbookDao.insert(cookbook);

        logger.debug("The new cookbook is: " + cookbook);
        logger.debug("The new cookbook ID is: " + cookbookId);

        // The cookbook id is added to the hash map and all is added to the session and is used by the jsp for output.
        newCookbookParts.put("cbId", String.valueOf((cookbookId)));
        req.setAttribute("newCookbookParts", newCookbookParts);

        logger.debug("The new cookbook parts WITH ID are: " + newCookbookParts);

        // Direct user to a results page and return results for user to see.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addCookbookResults.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Service Method to Remove all non-numeric characters from a string.
     * @return A string with only numeric characters.
     */
    private String removeDashes(String isbn) {
        // Remove dashes from ISBN number.
        isbn = isbn.replace("-", "");

        return isbn;
    }
}


