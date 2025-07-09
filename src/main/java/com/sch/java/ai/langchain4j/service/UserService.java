package com.sch.java.ai.langchain4j.service;

import com.sch.java.ai.langchain4j.entity.User;

public interface UserService {
    boolean register(String username, String password);
    User login(String username, String password);
} 