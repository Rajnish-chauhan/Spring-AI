package com.rajnishsystems.in.springaiollama.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AiConfig {

    @Bean("ollamaChatClient")
    public ChatClient ollamaChatModel(OllamaChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }
//    @Primary
    @Bean("googleGenAiChatClient")
    public ChatClient googleGenAiChatModel(GoogleGenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }
}
