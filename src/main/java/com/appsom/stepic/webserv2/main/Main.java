package com.appsom.stepic.webserv2.main;

import com.appsom.stepic.webserv2.accounts.AccountService;
import com.appsom.stepic.webserv2.accounts.UserProfile;
import com.appsom.stepic.webserv2.servlets.SessionsServlet;
import com.appsom.stepic.webserv2.servlets.UsersServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

        accountService.addNewUser(new UserProfile("admin", "admin", "admin@email.com"));
        accountService.addNewUser(new UserProfile("test", "test", "test@email.com"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/users");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/sessions");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
