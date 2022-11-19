package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.persistence.GenericDao;

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
 * A simple servlet to list all cookbooks that a user has.
 * @author eemclaughlin
 * @version 1.0 - 09-29-22
 */
@WebServlet(urlPatterns = {"/listCookbooks"})
public class ListCookbooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // If we search by last name then pass data through to getUsersByLastName
        // else run search for all users.

        // Line no longer needed as we switched off of userData and onto UserDao.
        // UserData userData = new UserData();
        GenericDao cookbookDao = new GenericDao(Cookbook.class);
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


        // TODO value needs to be changed to finalUserId.
        // Retrieve all cookbooks by user
        //List<Cookbook> cookbooks = new ArrayList<Cookbook>();
        //cookbooks = cookbookDao.getByPropertyEqual("user", fullUser);

        //Cookbook cookbooks = new Cookbook();
        req.setAttribute("cookbooks", cookbookDao.getByPropertyEqual("user", finalUserId));


        //req.setAttribute("cookbooks", cookbookDao.getAll());
        //req.setAttribute("cookbooks", cookbookDao.getByPropertyEqual("user", fullUser));


        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listCookbooks.jsp");
        dispatcher.forward(req, resp);
    }
}
