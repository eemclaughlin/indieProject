package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet that works with the jsps to add a cookbook to the database manually.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet("/addCookbookManually")
public class AddCookbookManually extends HttpServlet {

    // Create a logger for this class.
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * DoGet method that gets manually entered cookbook data from the jsp.  It then adds
     * the info to the database and sends the user to a confirmation page.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for Cookbooks.
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        // Declare the variables for the cookbook
        int pageCount = 0;

        // Get information entered from the form
        int cookbookId = 0;
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String publishedDate = req.getParameter("publishedDate");
        String description = req.getParameter("description");
        String unfixedIsbnTen = req.getParameter("isbnTen");
        String unfixedIsbnThirteen = req.getParameter("isbnThirteen");
        String pageCountText = req.getParameter("pageCount");
        String language = req.getParameter("language");
        String smallImageLink = req.getParameter("smallImageLink");
        String mediumImageLink = req.getParameter("mediumImageLink");
        String notes = req.getParameter("notes");

        // Remove the dashes from the ISBN.
        String isbnTen = removeDashes(unfixedIsbnTen);
        String isbnThirteen = removeDashes(unfixedIsbnThirteen);

        // Prep a couple variables so they are compatable with the database.
        // If no date was entered, set it to null.
        if (publishedDate.equals("")) {
            publishedDate = null;
        }
        // If no page count was entered, set it to zero, otherwise, convert to int.
        if (pageCountText.equals("")) {
            pageCount = 0;
        } else {
            pageCount = Integer.parseInt(pageCountText);
        }
        // If the image links are not entered, set them to the default image.
        if (smallImageLink.equals("")) {
            smallImageLink = "images/NoCover.png";
        }
        if (mediumImageLink.equals("")) {
            mediumImageLink = "images/NoCover.png";
        }

        // Create a map and add the cookbook information to it.
        // The map is added to the session and is used by the jsp for output.
        HashMap<String, String> newCookbookParts = new HashMap();
        newCookbookParts.put("cbTitle", title);
        newCookbookParts.put("cbAuthor", author);
        newCookbookParts.put("cbPublisher", publisher);
        newCookbookParts.put("cbPublishedDate", publishedDate);
        newCookbookParts.put("cbDescription", description);
        newCookbookParts.put("cbIsdnTen", isbnTen);
        newCookbookParts.put("cbIsdnThirteen", isbnThirteen);
        newCookbookParts.put("cbPageCount", String.valueOf(pageCount));
        newCookbookParts.put("cbLanguage", language);
        newCookbookParts.put("cbSmallImageLink", smallImageLink);
        newCookbookParts.put("cbNotes", notes);

        logger.debug("The new cookbook parts except for ID are: " + newCookbookParts);

        // Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        logger.debug("The user's username is: " + loggedInUser.getUserName());

        // Create the cookbook object
        Cookbook cookbook
                = new Cookbook(title, author, publisher, publishedDate, description,
                isbnTen, isbnThirteen, pageCount, language, smallImageLink, mediumImageLink,
                notes, loggedInUser);

        // Add the cookbook to the database
        cookbookId = cookbookDao.insert(cookbook);

        logger.debug("The new cookbook is: " + cookbook);
        logger.debug("The new cookbook ID is: " + cookbookId);

        // The cookbook id is added to the hash map and all is added to the session and
        // is used by the jsp for output.
        newCookbookParts.put("cbId", String.valueOf((cookbookId)));
        req.setAttribute("newCookbookParts", newCookbookParts);

        // Direct the user to the confirmation page
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
