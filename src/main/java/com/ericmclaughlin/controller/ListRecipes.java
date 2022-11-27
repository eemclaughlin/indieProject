package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Recipe;
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
 * A simple servlet to list all of a user's recipes.
 * @author eemclaughlin
 * @version 2.0 11-19-22
 */
@WebServlet(urlPatterns = {"/userHomepage"})
public class ListRecipes extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method that gets all recipes for a user and sends them to the jsp.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for Recipes.
        GenericDao recipeDao = new GenericDao(Recipe.class);

        // Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        int finalUserId = loggedInUser.getUserId();
        logger.debug("The user's username is: " + loggedInUser.getUserName());
        logger.debug("The user's id is: " + finalUserId);

        // Get all recipes for the user.
        req.setAttribute("recipes", recipeDao.getByPropertyEqual("user", finalUserId));

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userHomepage.jsp");
        dispatcher.forward(req, resp);
    }
}
