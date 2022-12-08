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
@WebServlet(urlPatterns = {"/searchRecipe"})
public class searchRecipes extends HttpServlet {

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

        // Get the search parameter.
        String search = req.getParameter("search");
        logger.debug("The search term is: " + search);

        // Get all recipes for the user.
        List<Recipe> allRecipes = recipeDao.getByPropertyEqual("user", finalUserId);

        // Instantiate a list for the search results.
        List<Recipe> searchResults = new ArrayList<>();

        // Search through list of recipes for the search term.
        // Reference: https://stackoverflow.com/questions/67284725/how-to-search-multiple-field-in-list-using-java
        for (Recipe recipe : allRecipes) {
            if (recipe.getRecipeName().contains(search)) {
                   searchResults.add(recipe);
            } else if (recipe.getCookbooks().getTitle().contains(search)) {
                // If the cookbook name contains the search term, add it to the list.
                searchResults.add(recipe);
            } else if (recipe.getDescription().contains(search)) {
                // If the recipe description contains the search term, add it to the list.
                searchResults.add(recipe);
            } else if (recipe.getCookbooks().getAuthor().contains(search)) {
                // If the recipe ingredients contains the search term, add it to the list.
                searchResults.add(recipe);
            } else if (recipe.getCookbooks().getDescription().contains(search)) {
                // If the recipe instructions contains the search term, add it to the list.
                searchResults.add(recipe);
            }
        }

        // Send all recipes to the jsp.
        req.setAttribute("recipes", searchResults);

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userHomepage.jsp");
        dispatcher.forward(req, resp);
    }
}
