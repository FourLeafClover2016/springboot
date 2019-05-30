package com.hwx.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆失败处理
 */
@Component
@Slf4j
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private HttpSession session;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("{}登陆失败:{}", httpServletRequest.getParameter("username"), e.getMessage());
        if ("locked".equals(e.getMessage())) {
            session.setAttribute("message", "locked");
        } else if ("unknown".equals(e.getMessage())) {
            session.setAttribute("message", "unknow");
        } else {
            session.setAttribute("message", "error");
        }
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/login");

    }
}
