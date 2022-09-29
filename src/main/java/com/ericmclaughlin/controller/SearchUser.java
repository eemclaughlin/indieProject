package com.ericmclaughlin.controller;

import com.ericmclaughlin.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to search for users.
 * @author eemclaughlin
 * @version 1.0 - 09-29-22
 */
@WebServlet(
        urlPatterns = {"/searchUser"}
)
public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // If we search by last name then pass data through to getUsersByLastName
        // else run search for all users.

        // Line no longer needed as we switched off of userData and onto UserDao.
        // UserData userData = new UserData();
        UserDao userDao = new UserDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", userDao.getByLastname(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", userDao.getAllUsers());
        }

        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
