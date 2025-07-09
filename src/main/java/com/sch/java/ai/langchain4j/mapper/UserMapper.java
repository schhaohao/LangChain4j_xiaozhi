package com.sch.java.ai.langchain4j.mapper;

import com.sch.java.ai.langchain4j.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    int insertUser(User user);
} 