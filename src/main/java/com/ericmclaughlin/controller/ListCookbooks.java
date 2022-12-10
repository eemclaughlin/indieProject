package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to list all cookbooks that a user has.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/listCookbooks"})
public class ListCookbooks extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method that gets all cookbooks for a user and sends them to the jsp.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for Cookbooks.
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        // Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        int finalUserId = loggedInUser.getUserId();
        logger.debug("The user's username is: " + loggedInUser.getUserName());
        logger.debug("The user's id is: " + finalUserId);

        // Get all cookbooks for the user.
        List<Cookbook> allCookbooks = cookbookDao.getByPropertyEqual("user", finalUserId);

        // Get the sort by parameter.
        String sortBy = req.getParameter("sortBy");
        logger.debug("The sort by is: " + sortBy);

        // If the user has not selected a sort, default to sorting by cookbook name.
        // Otherwise, sort by the user's selection.
        if (sortBy == null || sortBy.equals("") || sortBy.equals("cookbookName")) {
            allCookbooks.sort((c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
        } else if (sortBy.equals("cookbookAuthor")) {
            allCookbooks.sort((c1, c2) -> c1.getAuthor().compareTo(c2.getAuthor()));
        } else if (sortBy.equals("cookbookPublisher")) {
            allCookbooks.sort((c1, c2) -> c1.getPublisher().compareTo(c2.getPublisher()));
        }

        // Set the sortBy back to the request for the jsp dropdown selected value.
        req.setAttribute("sortBy", sortBy);

        // Send all cookbooks to the jsp.
        req.setAttribute("cookbooks", allCookbooks);

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listCookbooks.jsp");
        dispatcher.forward(req, resp);
    }
}
