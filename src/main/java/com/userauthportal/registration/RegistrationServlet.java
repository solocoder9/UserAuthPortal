package com.userauthportal.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/userauth?useSSL=false";
    private static final String username = "root";
    private static final String password = "solo";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uName = req.getParameter("name");
        String uEmail = req.getParameter("email");
        String uPassword = req.getParameter("pass");
        String uConformPassword = req.getParameter("re_pass");
        String uContact = req.getParameter("contact");

        String sqlQuery = "INSERT INTO user(name, email, password, contact_number) VALUES(?, ?, ?, ?)";
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");

        if (uName == null || uName.equals("")) {
        	req.setAttribute("status", "invalidName");
        	dispatcher = req.getRequestDispatcher("registration.jsp");
        	dispatcher.forward(req, resp);
        }
        if (uEmail == null || uEmail.equals("")) {
        	req.setAttribute("status", "invalidEmail");
        	dispatcher = req.getRequestDispatcher("registration.jsp");
        	dispatcher.forward(req, resp);
        }
        if (uPassword == null || uPassword.equals("")) {
        	req.setAttribute("status", "invalidPassword");
        	dispatcher = req.getRequestDispatcher("registration.jsp");
        	dispatcher.forward(req, resp);
        } else if (!uPassword.equals(uConformPassword)) {
        	req.setAttribute("status", "invalidConformPassword");
        	dispatcher = req.getRequestDispatcher("registration.jsp");
        	dispatcher.forward(req, resp);
        }
        if (uContact == null || uContact.equals("")) {
        	req.setAttribute("status", "invalidContact");
        	dispatcher = req.getRequestDispatcher("registration.jsp");
        	dispatcher.forward(req, resp);
        } else if (uContact.length() != 10) {
        	req.setAttribute("status", "invalidContactLength");
        	dispatcher = req.getRequestDispatcher("registration.jsp");
        	dispatcher.forward(req, resp);
        }
        

        // Explicitly load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Try-with-resources for Connection and PreparedStatement
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement pst = con.prepareStatement(sqlQuery)) {

                pst.setString(1, uName);
                pst.setString(2, uEmail);
                pst.setString(3, uPassword);
                pst.setString(4, uContact);

                int rowCount = pst.executeUpdate();
                req.setAttribute("status", rowCount > 0 ? "success" : "failed");

            } catch (SQLException e) {
                e.printStackTrace();
                req.setAttribute("status", "error: database operation failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            req.setAttribute("status", "error: JDBC driver not found");
        } finally {
            dispatcher.forward(req, resp);
        }
    }
}
