package com.sch.java.ai.langchain4j.assistant;


import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;


/**
 * @author sch
 * 初级的智能体
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryAssistant {

    String chat(String userMessage);

}
