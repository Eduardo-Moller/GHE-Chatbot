package br.com.ghe.chatbot.service.message;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class PromptMessageService {
    private final ChatClient chatClient;

    public PromptMessageService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String completion(String prompt) {
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}
