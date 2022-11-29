package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet that works with the jsps to edit a recipe
 * @author eemclaughlin
 * @version 2.0 11-28-22
 */
@WebServlet(urlPatterns = {"/editRecipe"})
public class EditRecipe extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Global variable to hold the recipe id.
    int recipeId;

    /**
     * doGet method for getting the recipe id from the homepage, getting the recipe by id,
     * and then prepopulating the edit recipe page with that recipe's data.
     * This also gets the list of cookbooks and populates the dropdown.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for all the aspects
        GenericDao cookbookDao = new GenericDao(Cookbook.class);
        //GenericDao userDao = new GenericDao(User.class);
        GenericDao recipeDao = new GenericDao(Recipe.class);

        try {
            // Establish the session and retrieve user
            HttpSession session = req.getSession();
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            int finalUserId = loggedInUser.getUserId();
            logger.debug("The user's username is: " + loggedInUser.getUserName());
            logger.debug("The user's id is: " + finalUserId);

            // Get the recipe id from the session.
            recipeId = Integer.parseInt(req.getParameter("recipeId"));
            logger.debug("The recipe id is: " + recipeId);

            // Get the recipe from the database.
            Recipe editRecipe = (Recipe) recipeDao.getById(recipeId);
            logger.debug("The recipe is: " + editRecipe);

            // Set the recipe information to the session.
            session.setAttribute("editRecipe", editRecipe);

            // Get the logged-in user's cookbooks.
            List<Cookbook> cookbookList = cookbookDao.getByPropertyEqual("user", finalUserId);

            // Set the cookbooks back into the session.
            req.setAttribute("cookbookList", cookbookList);

            // Forward to the jsp.
            RequestDispatcher dispatcher = req.getRequestDispatcher("editRecipe.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    /**
     * doPost method for adding a the edited recipe information back to the database.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Daos for Recipes, Users, and for Cookbooks.
        GenericDao recipeDao = new GenericDao(Recipe.class);
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        // Get the various changed parameters from the form.
        String recipeName = req.getParameter("recipeName");
        String description = req.getParameter("description");
        String notes = req.getParameter("notes");
        int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));

        // Get the cookbook id from the form.
        int cookbookId = Integer.parseInt(req.getParameter("cookbook"));

        logger.debug("cookbookId: " + cookbookId);
        logger.debug(recipeName + " " + description + " " + notes + " " + pageNumber);

        // Establish the session and retrieve user
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        logger.debug("The user's username is: " + loggedInUser.getUserName());

        // Get cookbook object by id.
        Cookbook cookbook = (Cookbook) cookbookDao.getById(cookbookId);

        // Get recipe object by id.
        Recipe recipe = (Recipe) recipeDao.getById(recipeId);

        // Set the recipe information.
        recipe.setRecipeName(recipeName);
        recipe.setDescription(description);
        recipe.setNotes(notes);
        recipe.setPageNumber(pageNumber);

        // Set the user information.
        recipe.setUser(loggedInUser);

        // Set the cookbook information.
        recipe.setCookbooks(cookbook);

        // Update the recipe.
        recipeDao.saveOrUpdate(recipe);

        // Redirect back to user homepage.
        String url = "userHomepage";
        resp.sendRedirect(url);
    }
}