package com.sch.java.ai.langchain4j;

import com.sch.java.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(5, "你是什么模型");
        System.out.println(answer);
    }

    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(7, "我是孙晨皓");
        System.out.println(answer1);

        String answer2 = separateChatAssistant.chat2(7, "我是谁");
        System.out.println(answer2);
    }

    @Test
    public void testUserInfo() {
        String answer = separateChatAssistant.chat3(8, "我是谁，我多大了", "晨皓", 23);
        System.out.println(answer);
    }

//    brew services start mongodb-community@8.0

}
