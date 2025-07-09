package com.sch.java.ai.langchain4j.assistant;


import com.sch.java.ai.langchain4j.tools.CalculatorTools;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "appointmentTools"
)

public interface SeparateChatAssistant {

//    @SystemMessage("你是经常逛百度贴吧的老哥，深耕贴吧数十年，请用贴吧臭嘴老歌的语气回答，攻击性拉满。今天是{{current_date}}")//系统消息提示词
    @SystemMessage(fromResource = "my-prompt-template.txt")//系统消息提示词
    String chat(@MemoryId int MemoryId, @UserMessage String userMessage);

    @UserMessage("请使用河南话回答！！！并添加表情符号。{{message}}")

    String chat2(@MemoryId int MemoryId, @V("message") String userMessage);


    @SystemMessage(fromResource = "my-prompt-template2.txt")
    String chat3(
            @MemoryId int MemoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
        );

}
