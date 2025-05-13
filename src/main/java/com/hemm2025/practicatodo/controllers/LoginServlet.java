/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hemm2025.practicatodo.controllers;

import com.hemm2025.practicatodo.Crud.crud;
import com.hemm2025.practicatodo.modelos.Usuarios;
import com.hemm2025.practicatodo.util.JwtUtil;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        // Invalidar la cookie que contiene el token JWT
        int exit = Integer.parseInt(request.getParameter("exit"));

        if (exit == 1) {
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
        
            }
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }

            }
            // Redirigir al usuario al login
            request.getSession().invalidate();
            response.sendRedirect("login/login.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String clave = request.getParameter("pass");

        // Verifica el usuario en la BD con Hibernate
        boolean usuario = validarUsuario(correo, clave);
        if (usuario) {
            String token = JwtUtil.generateToken(correo);
            String corre = JwtUtil.obtenerCorreo(token);
            // Guardamos el token en una cookie
            Cookie correoCookie = new Cookie("correo", corre);
            Cookie jwtCookie = new Cookie("jwtToken", token);
            jwtCookie.setHttpOnly(true); // No accesible por JavaScript
            jwtCookie.setPath("/"); // Disponible en toda la aplicación
            jwtCookie.setMaxAge(3600); // Expira en 1 hora
            correoCookie.setHttpOnly(true); // No accesible por JavaScript
            correoCookie.setPath("/"); // Disponible en toda la aplicación
            correoCookie.setMaxAge(3600); // Expira en 1 hora
            response.addCookie(jwtCookie);
            response.addCookie(correoCookie);

            response.setHeader("Authorization", "Bearer " + token);
            // O redirige a una JSP y almacena el token en sesión o cookie
            request.getSession().setAttribute("jwt", token);
            response.sendRedirect("ToDoListServlet.do");
        } else {
            request.setAttribute("error", 1);
            request.getRequestDispatcher("login/login.jsp").forward(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean validarUsuario(String correo, String clave) {
        crud crud = new crud();
        Usuarios u = crud.getUsuario(correo, clave);
        return u != null;

    }

}
