package com.kuka.springtemplate.service.impl;

import com.kuka.springtemplate.common.auth.AuthUser;
import com.kuka.springtemplate.common.auth.JwtUtil;
import com.kuka.springtemplate.model.User;
import com.kuka.springtemplate.service.AuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(User user) {
        // 保存user到数据库
        return null;
    }

    @Override
    public String login(String account, String password) {
        // 认证用户，认证失败抛出异常，由JwtAuthError的commence类返回401
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(account, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 如果认证通过，返回jwt
        final AuthUser userDetails = (AuthUser) userDetailsService.loadUserByUsername(account);
        final String token = jwtUtil.generateToken(userDetails.getUser());
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        String newToken = null;
        try {
            newToken = jwtUtil.refreshToken(oldToken);
        } catch (Exception e) {
            log.debug("Exception details: ", e);
            log.info("Invalid token");
        }
        return newToken;
    }
}
