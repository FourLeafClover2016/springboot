package com.hwx.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwx.dao.LockedUserMapper;
import com.hwx.model.LockedUser;
import com.hwx.tools.UserLockedMemory;
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
import java.util.Date;

/**
 * 登陆失败处理
 */
@Component
@Slf4j
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LockedUserMapper lockedUserMapper;

    @Autowired
    private UserLockedMemory userLockedMemory;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String url = "/login";
        HttpSession session = httpServletRequest.getSession();
        log.info("登陆失败:{}", e.getMessage());
        if ("locked".equals(e.getMessage())) {
            session.setAttribute("message", "locked");
            url = "/login?error=locked";
        } else if ("unknown".equals(e.getMessage())) {
            session.setAttribute("message", "unknown");
            url = "/login?error=unknown";
        } else {
            // 记录登陆信息，如果账户输入次数超限，锁定用户
            Date lockedDate = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
            String username = httpServletRequest.getParameter("username");
            lockedUserMapper.insert(new LockedUser(username, new Date()));
            int loginErrorCount = lockedUserMapper.selectCount(username, lockedDate);
            // 超过限制次数，锁定账户
            if (loginErrorCount >= 5) {
                userLockedMemory.lockUser(username);
                session.setAttribute("message", "locked");
                url = "/login?error=locked";
            } else {
                session.setAttribute("message", "error");
                url = "/login?error=error";
            }
        }
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, url);

    }
}
