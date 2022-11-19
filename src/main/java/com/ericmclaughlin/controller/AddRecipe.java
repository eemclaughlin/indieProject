package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet used to add a recipe to the database.
 * @author eemclaughlin
 * @version 2.0 11-19-22
 */
@WebServlet("/addRecipe")
public class AddRecipe extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method for populating the dropdown menu with the user's cookbooks.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for the cookbooks.
        GenericDao cookbookDao = new GenericDao(Cookbook.class);
        GenericDao userDao = new GenericDao(User.class);

        try {
            // Establish the session and retrieve username.
            HttpSession session = req.getSession();
            String storedUsername = (String)session.getAttribute("userName");

            logger.debug("The user's username is: " + storedUsername);

            // Get Id of user by username
            List<User> userIds = userDao.getByPropertyEqual("userName", storedUsername);

            // Log Statement
            for(User userId:userIds) logger.debug("The user's id is: " + userId.getUserId());

            // Get only the first user id that is returned.
            int finalUserId = userIds.get(0).getUserId();
            logger.debug("The user's id is: " + finalUserId);

            // Get the logged-in user's cookbooks.
            List<Cookbook> cookbookList = cookbookDao.getByPropertyEqual("user", finalUserId);

            // Set the cookbooks back into the session.
            req.setAttribute("cookbookList", cookbookList);

            // Forward to the jsp.
            RequestDispatcher dispatcher = req.getRequestDispatcher("addRecipe.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    /**
     * doPost method for adding a recipe to the database.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Daos for Recipes, Users, and for Cookbooks.
        GenericDao recipeDao = new GenericDao(Recipe.class);
        GenericDao cookbookDao = new GenericDao(Cookbook.class);
        GenericDao userDao = new GenericDao(User.class);

        // Get information entered from the form
        String recipeName = req.getParameter("recipeName");
        String description = req.getParameter("description");
        String notes = req.getParameter("notes");
        int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));

        // Get the cookbook id from the form.
        int cookbookId = Integer.parseInt(req.getParameter("cookbook"));

        logger.debug("cookbookId: " + cookbookId);
        logger.debug(recipeName + " " + description + " " + notes + " " + pageNumber);

        // Establish session to get user id.
        HttpSession session = req.getSession();
        int finalUserId = (int)session.getAttribute("userId");

        // Get user object by id
        User user = (User) userDao.getById(finalUserId);

        // Get cookbook object by id.
        Cookbook cookbook = (Cookbook) cookbookDao.getById(cookbookId);

        // Take all parts and put together into a recipe.  Add said recipe to database.
        Recipe recipe = new Recipe(recipeName, description, notes, pageNumber, user, cookbook);
        recipeDao.insert(recipe);

        // Redirect back to user homepage.
        String url = "userHomepage";
        resp.sendRedirect(url);
    }
}
