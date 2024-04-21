package org.fullstack4.springmvc.controller.filter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.service.LoginServiceIf;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@NoArgsConstructor
public class LoginCheckFilter extends OncePerRequestFilter {
    private LoginServiceIf service;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Login Check Filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if(session.getAttribute("memberDTO")==null) {
            Cookie cookies[] = req.getCookies();
            Cookie logincookie = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("autologin")) {
                    logincookie = cookie;
                }
            }
            if (logincookie != null) {
                try {
                    session.setAttribute("memberDTO", service.Cookie_login(logincookie.getValue()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            if (session.getAttribute("memberDTO") == null) {
                res.sendRedirect("/login/login");
            }
            else{
                filterChain.doFilter(request, response);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        log.info("check uri => " + path);

        if(path.startsWith("/login/login/")) {
            return true;
        }

        return false;
    }

}