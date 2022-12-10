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
import java.util.ArrayList;
import java.util.List;

/**
 * A servlet to process a search term that the user provides and return results.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/searchCookbook"})
public class SearchCookbooks extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method to get all cookbooks for a user, based on a search term, and
     * display the results.
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

        // Get the search parameter.
        String search = req.getParameter("search").toUpperCase();
        logger.debug("The search term is: " + search);

        // Get all cookbooks for the user.
        List<Cookbook> allCookbooks = cookbookDao.getByPropertyEqual("user", finalUserId);

        // Instantiate a list for the search results.
        List<Cookbook> searchResults = new ArrayList<>();

        // Search through list of cookbooks for the search term and add to list
        // Reference: https://stackoverflow.com/questions/67284725/how-to-search-multiple-field-in-list-using-java
        for (Cookbook cookbook : allCookbooks) {
            if (cookbook.getTitle().toUpperCase().contains(search)) {
                searchResults.add(cookbook);
            } else if (cookbook.getAuthor().toUpperCase().contains(search)) {
                searchResults.add(cookbook);
            } else if (cookbook.getPublisher().toUpperCase().contains(search)) {
                searchResults.add(cookbook);
            } else if (cookbook.getNotes().toUpperCase().contains(search)) {
                searchResults.add(cookbook);
            }
        }

        // Set results to be available to the jsp.
        req.setAttribute("cookbooks", searchResults);

        // Return to results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listCookbooks.jsp");
        dispatcher.forward(req, resp);
    }
}
