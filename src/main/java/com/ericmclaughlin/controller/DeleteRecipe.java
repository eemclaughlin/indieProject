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

@WebServlet(urlPatterns = {"/deleteRecipe"})
public class DeleteRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for all the aspects
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

            // Forward to the jsp.
            RequestDispatcher dispatcher = req.getRequestDispatcher("userHomepage");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
