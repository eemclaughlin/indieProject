package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Recipe;
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

/**
 * Servlet that works with the deleteRecipe jsp to delete a recipe from the database.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/deleteRecipe"})
public class DeleteRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method for deleting a recipe.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao
        GenericDao recipeDao = new GenericDao(Recipe.class);

        try {
            // Get the recipe id from the request
            int recipeId = Integer.parseInt(req.getParameter("recipeId"));
            logger.debug("The recipe's id is: " + recipeId);

            // Get the recipe from the database.
            Recipe deleteRecipe = (Recipe) recipeDao.getById(recipeId);
            logger.debug("The recipe is: " + deleteRecipe);

            // Delete the recipe from the database.
            recipeDao.delete(deleteRecipe);

            // Forward back to the listRecipes page via userHomepage.java
            RequestDispatcher dispatcher = req.getRequestDispatcher("userHomepage");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            logger.error("There was an error deleting the recipe: " + e);
            //Redirect to the error page.
            resp.sendRedirect("error.jsp");
            throw new ServletException(e);
        }
    }
}
