/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.controllers;

import com.ecommerce.logic.UserLogic;
import com.ecommerce.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos.chiquillo
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserLogic user = new UserLogic();
        List<User> users = user.getCustomerList();
        request.getSession().setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        String email = null;
        String password = null;
        String username = null;
        UserLogic user = new UserLogic();
        switch(operation){
            case "login":
                email = request.getParameter("email");
                password = request.getParameter("password");
                int id = user.login(email, password);
                request.getSession().invalidate();
                if( id != 0){
                    request.getSession().setAttribute("userid", id);
                    request.getRequestDispatcher("ProductController").forward(request, response);
                }
                break;
             
            case "register":
                username = request.getParameter("username");
                email = request.getParameter("email");
                password = request.getParameter("password");
                user.addUser(new User(username, email, password));
                response.sendRedirect("login.jsp");
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
