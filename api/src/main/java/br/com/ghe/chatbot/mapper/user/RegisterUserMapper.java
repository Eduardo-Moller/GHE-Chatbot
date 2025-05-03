package br.com.ghe.chatbot.mapper.user;

import br.com.ghe.chatbot.domain.User;
import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.controller.dto.response.user.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RegisterUserMapper {

    public static User toEntity(RegisterUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static UserResponse toResponse(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
