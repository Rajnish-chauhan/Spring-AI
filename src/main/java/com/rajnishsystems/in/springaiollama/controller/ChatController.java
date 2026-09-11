package com.rajnishsystems.in.springaiollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    private final ChatClient ollamaChatClient;
    private final ChatClient googleGenAiChatClient;


    public ChatController(@Qualifier("ollamaChatClient") ChatClient ollamaChatModel,@Qualifier("googleGenAiChatClient") ChatClient googleGenAiChatClient) {
        this.googleGenAiChatClient = googleGenAiChatClient;
        this.ollamaChatClient = ollamaChatModel;
    }

    @GetMapping("/chat")
    public ResponseEntity<String>chat(@RequestParam(value = "q") String message){
        String content =this.googleGenAiChatClient
                .prompt(message)
                .call()
                .content();
        return ResponseEntity.ok(content);
    }
}
