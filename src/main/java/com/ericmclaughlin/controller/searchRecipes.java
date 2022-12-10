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
 * A servlet to search for recipes by search term and return the results.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/searchRecipe"})
public class searchRecipes extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method to get all recipes for a user, based on a search term and retunr the
     * results to the user.
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

        // Get the search parameter.
        String search = req.getParameter("search").toUpperCase();
        logger.debug("The search term is: " + search);

        // Get all recipes for the user.
        List<Recipe> allRecipes = recipeDao.getByPropertyEqual("user", finalUserId);

        // Instantiate a list for the search results.
        List<Recipe> searchResults = new ArrayList<>();

        // Search through list of recipes for the search term and add to new list
        // Reference: https://stackoverflow.com/questions/67284725/how-to-search-multiple-field-in-list-using-java
        for (Recipe recipe : allRecipes) {
            if (recipe.getRecipeName().toUpperCase().contains(search)) {
                   searchResults.add(recipe);
            } else if (recipe.getCookbooks().getTitle().toUpperCase().contains(search)) {
                // If the cookbook name contains the search term, add it to the list.
                searchResults.add(recipe);
            } else if (recipe.getDescription().toUpperCase().contains(search)) {
                // If the recipe description contains the search term, add it to the list.
                searchResults.add(recipe);
            } else if (recipe.getCookbooks().getAuthor().toUpperCase().contains(search)) {
                // If the recipe ingredients contains the search term, add it to the list.
                searchResults.add(recipe);
            } else if (recipe.getCookbooks().getDescription().toUpperCase().contains(search)) {
                // If the recipe instructions contains the search term, add it to the list.
                searchResults.add(recipe);
            }
        }

        // Send all relevant recipes up to be available to the jsp.
        req.setAttribute("recipes", searchResults);

        // Return to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userHomepage.jsp");
        dispatcher.forward(req, resp);
    }
}
