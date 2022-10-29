package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
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

@WebServlet("/addRecipe")
public class AddRecipe extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        try {
            List<Cookbook> cookbookList = cookbookDao.getAll();
            req.setAttribute("cookbookList", cookbookList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("addRecipe.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
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
        int cookbookId = Integer.parseInt(req.getParameter("cookbook"));
        // int cookbookId = 1;

        // TODO Remove Sys. out prints
        System.out.println("Add Recipe Java recipename " + recipeName);
        System.out.println("Add Recipe Java description " + description);
        System.out.println("Add Recipe Java notes " + notes);
        System.out.println("Add Recipe Java pagenumber " + pageNumber);
        System.out.println("Add Recipe Java cookbookid " + cookbookId);


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
