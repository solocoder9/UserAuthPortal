package com.userauthportal.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/userauth?useSSL=false";
    private static final String username = "root";
    private static final String password = "solo";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uEmail = req.getParameter("username");
        String uPassword = req.getParameter("password");

        String sqlQuery = "SELECT * FROM user WHERE email = ? AND password = ?";
        
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = null;
        
        if (uEmail == null || uEmail.equals("")) {
        	req.setAttribute("status", "invalidEmail");
        	dispatcher = req.getRequestDispatcher("login.jsp");
        	dispatcher.forward(req, resp);
        }
        if (uPassword == null || uPassword.equals("")) {
        	req.setAttribute("status", "invlidPassword");
        	dispatcher = req.getRequestDispatcher("login.jsp");
        	dispatcher.forward(req, resp);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement pst = con.prepareStatement(sqlQuery)) {

                pst.setString(1, uEmail);
                pst.setString(2, uPassword);
                
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        session.setAttribute("name", rs.getString("name"));
                        dispatcher = req.getRequestDispatcher("index.jsp");
                    } else {
                        req.setAttribute("status", "failed");
                        dispatcher = req.getRequestDispatcher("login.jsp");
                    }
                }
            }
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
