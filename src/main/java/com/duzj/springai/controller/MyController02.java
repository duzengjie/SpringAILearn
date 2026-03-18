package com.duzj.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/02")
public class MyController02 {

    @Autowired
    private  ChatModel chatModel;

    @GetMapping("/ai")
    void generation(String userInput) {
        // 程序化创建ChatClient实例
        ChatClient chatClient = ChatClient.create(chatModel);
        String content = chatClient.prompt()
                .user(userInput)
                .call()
                .content();
        System.out.println(content);

        // 或者使用构建器进行更多控制
        ChatClient.Builder builder = ChatClient.builder(chatModel);
        ChatClient customChatClient = builder
                .defaultSystem("You are a helpful assistant.")
                .build();

        String content2 = customChatClient.prompt()
                .user(userInput)
                .call()
                .content();
        System.out.println(content2);
    }
}
