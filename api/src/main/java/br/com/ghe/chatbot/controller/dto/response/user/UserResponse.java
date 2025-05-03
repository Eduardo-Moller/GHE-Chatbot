package br.com.ghe.chatbot.controller.dto.response.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
}
