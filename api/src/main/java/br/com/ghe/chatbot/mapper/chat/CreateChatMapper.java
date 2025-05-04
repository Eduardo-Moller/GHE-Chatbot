package br.com.ghe.chatbot.mapper.chat;

import br.com.ghe.chatbot.controller.dto.request.chat.CreateChatRequest;
import br.com.ghe.chatbot.controller.dto.response.chat.CreateChatResponse;
import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.UserDomain;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateChatMapper {

    public static ChatDomain toEntity(UserDomain user, CreateChatRequest request) {
        return ChatDomain.builder()
                .name(request.getName())
                .user(user)
                .build();
    }

    public static CreateChatResponse toResponse(ChatDomain entity) {
        return CreateChatResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
