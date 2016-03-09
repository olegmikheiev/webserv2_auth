package com.appsom.stepic.webserv2.servlets;

import com.appsom.stepic.webserv2.accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersServlet extends HttpServlet {
    private final AccountService accountService;

    public UsersServlet(AccountService accountService){
        this.accountService = accountService;
    }

    // Get public user profile
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // Sign Up
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // Change user profile
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // Sign Out
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
