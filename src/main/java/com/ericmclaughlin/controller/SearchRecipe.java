package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to search for users.
 * @author eemclaughlin
 * @version 1.0 - 09-29-22
 */
@WebServlet(
        urlPatterns = {"/searchRecipe"}
)
public class SearchRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // If we search by last name then pass data through to getUsersByLastName
        // else run search for all users.

        // Line no longer needed as we switched off of userData and onto UserDao.
        // UserData userData = new UserData();
        GenericDao recipeDao = new GenericDao(Recipe.class);
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("recipes", recipeDao.getByPropertyLike("recipeName", req.getParameter("searchTermRecipe")));
        } else {
            req.setAttribute("recipes", recipeDao.getAll());
        }

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resultsRecipe.jsp");
        dispatcher.forward(req, resp);
    }
}
