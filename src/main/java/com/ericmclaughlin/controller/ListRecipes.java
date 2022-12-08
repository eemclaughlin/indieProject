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
        List<Recipe> allRecipes = recipeDao.getByPropertyEqual("user", finalUserId);

        // Get the sort by parameter.
        String sortBy = req.getParameter("sortBy");
        logger.debug("The sort by is: " + sortBy);

        // If the user has not selected a sort, default to sorting by recipe name.
        if (sortBy == null || sortBy.equals("") || sortBy.equals("recipeName")) {
            allRecipes.sort((r1, r2) -> r1.getRecipeName().compareTo(r2.getRecipeName()));
        } else if (sortBy.equals("cookbookName")) {
            allRecipes.sort((r1, r2) -> r1.getCookbooks().getTitle().compareTo(r2.getCookbooks().getTitle()));
        } else if (sortBy.equals("cookbookAuthor")) {
            allRecipes.sort((r1, r2) -> r1.getCookbooks().getAuthor().compareTo(r2.getCookbooks().getAuthor()));
        }

        // Set the sortBy back to the request for the jsp dropdown selected.
        req.setAttribute("sortBy", sortBy);

        // Send all recipes to the jsp.
        req.setAttribute("recipes", allRecipes);

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userHomepage.jsp");
        dispatcher.forward(req, resp);
    }
}
