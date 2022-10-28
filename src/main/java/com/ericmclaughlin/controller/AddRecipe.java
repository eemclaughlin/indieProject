package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddRecipe extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Daos for Recipes and for Cookbooks.
        GenericDao recipeDao = new GenericDao(Recipe.class);
        GenericDao cookbookDao = new GenericDao(Cookbook.class);
        GenericDao userDao = new GenericDao(User.class);

        // Get information entered from the form
        String recipeName = req.getParameter("recipeName");
        String description = req.getParameter("description");
        String notes = req.getParameter("notes");
        int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));

        // TODO Establish way cookbook id to populate database with.
        // TODO Use dropdown on form to choose book and return id.
        int cookbookId = 1;

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
