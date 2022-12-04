package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet that works with the jsps to edit a cookbook's info.
 * @author eemclaughlin
 * @version 2.0 11-28-22
 */
@WebServlet(urlPatterns = {"/editCookbook"})
public class EditCookbook extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Global variable to hold the recipe id.
    int cookbookId;

    /**
     * doGet method for getting the cookbook id from the cookbook list, getting the cookbook by id,
     * and then prepopulating the edit cookbook page with that cookbooks's data.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for all the aspects
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        try {
            try {
                // Get the cookbook id from the request
                cookbookId = Integer.parseInt(req.getParameter("cookbookId"));
                logger.debug("The cookbook id is: " + cookbookId + "SPACE CHECK");
            } catch (NumberFormatException e) {
                logger.error("The cookbook id " + cookbookId + " is not a number.");
                // Redirect to the error page.
                resp.sendRedirect("error.jsp");
                throw new ServletException(e);
            }

            // Get the cookbook from the database.
            Cookbook editCookbook = (Cookbook) cookbookDao.getById(cookbookId);
            logger.debug("The recipe is: " + editCookbook);

            // Establish the session and retrieve username.
            HttpSession session = req.getSession();
            // Set the cookbook information to the session.
            session.setAttribute("editCookbook", editCookbook);

            // Forward to the jsp.
            RequestDispatcher dispatcher = req.getRequestDispatcher("editCookbook.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            logger.error("There was an error editing the cookbook: " + e);
            //Redirect to the error page.
            resp.sendRedirect("error.jsp");
            throw new ServletException(e);
        }
    }

    /**
     * doPost method for adding the edited cookbook information back to the database.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Variable declaration.
        int pageCount = 0;

        // Call on the Daos
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        // Get the various changed parameters from the form.
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String publishedDate = req.getParameter("publishedDate");
        String description = req.getParameter("description");
        String isbnTen = req.getParameter("isbnTen");
        String isbnThirteen = req.getParameter("isbnThirteen");
        String pageCountText = req.getParameter("pageCount");
        String language = req.getParameter("language");
        String smallImageLink = req.getParameter("smallImageLink");
        String mediumImageLink = req.getParameter("mediumImageLink");
        String notes = req.getParameter("notes");

        logger.debug(title + " " + author + " " + publisher + " " + publishedDate + " "
                + description + " " + isbnTen + " " + isbnThirteen + " " + pageCountText
                + " " + language + " " + smallImageLink + " " + mediumImageLink + " "
                + notes);

        // Prep a couple variables for the database.
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


        // Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        logger.debug("The user's username is: " + loggedInUser.getUserName());

        // Get cookbook object by id.
        Cookbook cookbook = (Cookbook) cookbookDao.getById(cookbookId);
        logger.debug("The cookbook in POST is: " + cookbook);

// Set the new values to the cookbook object.
        cookbook.setTitle(title);
        cookbook.setAuthor(author);
        cookbook.setPublisher(publisher);
        cookbook.setPublishedDate(publishedDate);
        cookbook.setDescription(description);
        cookbook.setIsdnTen(isbnTen);
        cookbook.setIsdnThirteen(isbnThirteen);
        cookbook.setPageCount(pageCount);
        cookbook.setLanguage(language);
        cookbook.setSmallImageLink(smallImageLink);
        cookbook.setMediumImageLink(mediumImageLink);
        cookbook.setNotes(notes);

        // Set the user to the cookbook.
        cookbook.setUser(loggedInUser);

        // Update the cookbook in the database.
        cookbookDao.saveOrUpdate(cookbook);

        // Redirect back to user homepage.
        String url = "listCookbooks";
        resp.sendRedirect(url);
    }
}

