package com.hwx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("登陆失败:{}", e.getMessage());
        if ("账户已经被锁定".equals(e.getMessage())) {
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/login?error=isLocked");
        } else if ("未知用户".equals(e.getMessage())){
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/login?error=null");
        }else {
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/login?error=error");
        }

    }
}
