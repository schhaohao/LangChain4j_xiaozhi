package com.sch.java.ai.langchain4j;

import com.sch.java.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.spring.AiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat() {

        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String result = assistant.chat("你是谁?");
        System.out.println(result);

    }

    @Autowired
    private Assistant assistant;

    @Test
    public void testChat2() {
        String result = assistant.chat("我是谁?");
        System.out.println(result);
    }


}



