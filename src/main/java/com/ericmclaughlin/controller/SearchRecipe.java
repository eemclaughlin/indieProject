package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;
import net.bytebuddy.description.type.TypeList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        GenericDao userDao = new GenericDao(User.class);

        // Establish the session and retrieve user name.
        HttpSession session = req.getSession();
        String storedUsername = (String)session.getAttribute("userName");
        System.out.println(storedUsername);

        // Get Id of user by username
        List<User> userIds = new ArrayList<User>();
        userIds= userDao.getByPropertyEqual("userName", storedUsername);
        // TODO Remove sys out print
        for(User userId:userIds) System.out.println(userId.getUserId());

        int finalUserId = (int)userIds.get(0).getUserId();
        // TODO Remove sys out print
        System.out.println(finalUserId);



        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("recipes", recipeDao.getByPropertyLike("recipeName", req.getParameter("searchTermRecipe")));
        } else {
            // TODO value needs to be changed to finalUserId.
            //req.setAttribute("recipes", recipeDao.getAll());
            req.setAttribute("recipes", recipeDao.getByPropertyEqual("user", 1));

        }

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resultsRecipe.jsp");
        dispatcher.forward(req, resp);
    }
}
