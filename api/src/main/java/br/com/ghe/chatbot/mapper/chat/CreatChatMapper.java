package br.com.ghe.chatbot.mapper.chat;

import br.com.ghe.chatbot.controller.dto.request.CreateChatRequest;
import br.com.ghe.chatbot.controller.dto.response.CreatChatResponse;
import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.UserDomain;

public class CreatChatMapper {

    public static ChatDomain toEntity(UserDomain user, CreateChatRequest request) {
        return ChatDomain.builder()
                .name(request.getName())
                .user(user)
                .build();
    }

    public static CreatChatResponse toResponse(ChatDomain entity) {
        return CreatChatResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
