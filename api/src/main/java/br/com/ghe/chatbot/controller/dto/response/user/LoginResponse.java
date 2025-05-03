package br.com.ghe.chatbot.controller.dto.response.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private String accessToken;
}