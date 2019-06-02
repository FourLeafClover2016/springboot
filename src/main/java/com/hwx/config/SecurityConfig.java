package com.hwx.config;

import com.hwx.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Huawei Xie
 * @date: 2019/4/1
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
              //  .failureForwardUrl("/login")
                .failureHandler(authenticationFailHandler)
                .successHandler(authenticationSuccessHandler)
              //  .successForwardUrl("/index")
                .loginProcessingUrl("/user/login")

                .and()
                .authorizeRequests()
                .antMatchers( "/login", "/user/login", "/layui/**", "/images/**", "/assets/**", "/css/**", "/iconfont/**", "/js/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and().csrf().disable();
      //  http.sessionManagement().maximumSessions(1).expiredUrl("/login");
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
