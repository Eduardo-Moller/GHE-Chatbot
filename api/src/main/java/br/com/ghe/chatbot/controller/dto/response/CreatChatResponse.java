package br.com.ghe.chatbot.controller.dto.response;

import lombok.*;

@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreatChatResponse {

    private Long id;
    private String name;
}
