package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import net.bytebuddy.description.type.TypeList;
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
import java.util.HashSet;
import java.util.List;

//TODO This whole class may be unnecessary.

/**
 * A simple servlet to search for recipes.
 * @author eemclaughlin
 * @version 2.0 11-19-22
 */
@WebServlet(urlPatterns = {"/searchRecipe"})
public class SearchRecipe extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method that gets aa recipe based on what is entered and sends the results to the jsp.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Daos for Recipes.
        GenericDao recipeDao = new GenericDao(Recipe.class);

        // Establish the session and retrieve username.
        HttpSession session = req.getSession();
        String storedUsername = (String)session.getAttribute("userName");

        logger.debug("The user's username is: " + storedUsername);

        // Call on session for the saved user id for use to filter by user.
        int finalUserId = (int)session.getAttribute("userId");
        logger.debug("The user's id is: " + finalUserId);

        //TODO This needs work to only get back result of recipes that this user owns.
        // If the search button is pressed, take data from the form and search for it.
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("recipes", recipeDao.getByPropertyLike("recipeName", req.getParameter("searchTermRecipe")));
        } else {
            req.setAttribute("recipes", recipeDao.getByPropertyEqual("user", finalUserId));
        }

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchRecipeResults.jsp");
        dispatcher.forward(req, resp);
    }
}
