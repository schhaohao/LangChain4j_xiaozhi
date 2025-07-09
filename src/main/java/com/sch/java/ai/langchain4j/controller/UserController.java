package com.sch.java.ai.langchain4j.controller;

import com.sch.java.ai.langchain4j.entity.User;
import com.sch.java.ai.langchain4j.service.UserService;
import com.sch.java.ai.langchain4j.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestParam String username, @RequestParam String password) {
        boolean success = userService.register(username, password);
        Map<String, Object> res = new HashMap<>();
        res.put("success", success);
        res.put("msg", success ? "注册成功" : "用户名已存在");
        return res;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password, @RequestParam(required = false, defaultValue = "false") boolean rememberMe) {
        User user = userService.login(username, password);
        Map<String, Object> res = new HashMap<>();
        if (user != null) {
            long expire = rememberMe ? 1000L * 60 * 60 * 24 * 7 : 1000L * 60 * 60 * 24; // 7天或1天
            String token = JwtUtil.generateToken(username, expire);
            res.put("success", true);
            res.put("msg", "登录成功");
            res.put("token", token);
        } else {
            res.put("success", false);
            res.put("msg", "用户名或密码错误");
        }
        return res;
    }
} 