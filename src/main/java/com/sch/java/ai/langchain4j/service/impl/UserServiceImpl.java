package com.sch.java.ai.langchain4j.service.impl;

import com.sch.java.ai.langchain4j.entity.User;
import com.sch.java.ai.langchain4j.mapper.UserMapper;
import com.sch.java.ai.langchain4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean register(String username, String password) {
        if (userMapper.findByUsername(username) != null) {
            return false; // 用户已存在
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
} 