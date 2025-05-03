package br.com.ghe.chatbot.controller.dto.request.chat;

import lombok.*;

@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateChatRequest {

    private String name;
}
