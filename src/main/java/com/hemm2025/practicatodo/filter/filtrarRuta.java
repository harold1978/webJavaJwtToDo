/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemm2025.practicatodo.filter;

import com.hemm2025.practicatodo.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"*.do"})  // Aquí defines la ruta protegida
public class filtrarRuta implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String token = (String) req.getSession().getAttribute("jwt");

            if (token != null && JwtUtil.validateToken(token)) {
                chain.doFilter(request, response); // acceso permitido
            } else {
                res.sendRedirect(req.getContextPath() + "/login/login.jsp"); // o devolver error 401
            }
 

    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
