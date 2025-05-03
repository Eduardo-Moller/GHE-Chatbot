package br.com.ghe.chatbot.controller.dto.response.chat;

import lombok.*;

@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ChatResponse {

    private Long id;
    private String name;
}
