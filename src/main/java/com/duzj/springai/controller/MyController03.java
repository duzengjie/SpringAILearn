package com.duzj.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/03")
public class MyController03 {

    @Autowired
    private  ChatClient openAiChatClient;
    @Autowired
    private  ChatClient zhipuChatClient;

    @GetMapping("/ai")
    void generation(String userInput) {
        String content = openAiChatClient.prompt()
                .user(userInput)
                .call()
                .content();
        System.out.println(content);


        String content2 = zhipuChatClient.prompt()
                .user(userInput)
                .call()
                .content();
        System.out.println(content2);
    }
}
