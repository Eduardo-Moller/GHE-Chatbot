package br.com.ghe.chatbot.mapper.user;

import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.controller.dto.response.user.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RegisterUserMapper {

    public static UserDomain toEntity(RegisterUserRequest request) {
        return UserDomain.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static UserResponse toResponse(UserDomain entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
