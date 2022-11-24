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

@WebServlet("/addCookbookManually")
public class AddCookbookManually extends HttpServlet {

    // Create a logger for this class.
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

        GenericDao cookbookDao = new GenericDao(Cookbook.class);
        GenericDao userDao = new GenericDao(User.class);

        // Declare the variables for the cookbook

        int pageCount = 0;
        logger.debug("The 0 pageCount: " + pageCount);

        // Get information entered from the form
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String description = req.getParameter("description");
        String isbnTen = req.getParameter("isbnTen");
        String isbnThirteen = req.getParameter("isbnThirteen");
        pageCount = Integer.parseInt(req.getParameter("pageCount"));
        String language = req.getParameter("language");
        String smallImageLink = "images/NoCover.png";
        String notes = req.getParameter("notes");

        // Creates a map and adds the cookbook information to it.
        // The map is added to the session and is used by the jsp for output.
        HashMap<String, String> newCookbookParts = new HashMap();
        newCookbookParts.put("cbTitle", title);
        newCookbookParts.put("cbAuthor", author);
        newCookbookParts.put("cbPublisher", publisher);
        newCookbookParts.put("cbDescription", description);
        newCookbookParts.put("cbIsdnTen", isbnTen);
        newCookbookParts.put("cbIsdnThirteen", isbnThirteen);
        newCookbookParts.put("cbPageCount", String.valueOf(pageCount));
        newCookbookParts.put("cbLanguage", language);
        newCookbookParts.put("cbSmallImageLink", smallImageLink);
        newCookbookParts.put("cbNotes", notes);

        req.setAttribute("newCookbookParts", newCookbookParts);

        logger.debug("The new cookbook parts are: " + newCookbookParts);

// Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        logger.debug("The user's username is: " + loggedInUser.getUserName());

        // Create the cookbook object
        Cookbook cookbook = new Cookbook(title, author, publisher, null, description,
                isbnTen, isbnThirteen, pageCount, language, smallImageLink, null, notes, loggedInUser);

        // Add the cookbook to the database
        cookbookDao.insert(cookbook);

        // Direct the user to the confirmation page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addCookbookResults.jsp");
        dispatcher.forward(req, resp);
    }
}
