package com.sch.java.ai.langchain4j;

import com.sch.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

//    @Test
//    public void testInsert() {
//        mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
//    }

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录2");

        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindId() {
        ChatMessages chatMessages = mongoTemplate.findById("6825b422fdc35e43dda90edd", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate() {
        Criteria  criteria = Criteria.where("_id").is("6825b422fdc35e43dda90edd");
        Query query = new Query(criteria);
        Update  update = new Update();
        update.set("content", "更新后的内容");

        mongoTemplate.upsert(query, update, ChatMessages.class);

    }

    @Test
    public void testUpdate2() {
        Criteria  criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update  update = new Update();
        update.set("content", "更新后的内容2");

        mongoTemplate.upsert(query, update, ChatMessages.class);

    }

    @Test
    public void testDelete() {
        Criteria  criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }


}
