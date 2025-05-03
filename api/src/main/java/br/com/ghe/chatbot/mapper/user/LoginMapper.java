package br.com.ghe.chatbot.mapper.user;

import br.com.ghe.chatbot.controller.dto.response.user.LoginResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginMapper {

    public static LoginResponse toResponse(String accessToken) {
        return LoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
