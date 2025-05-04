package br.com.ghe.chatbot.mapper.chat;

import br.com.ghe.chatbot.controller.dto.response.chat.ChatResponse;
import br.com.ghe.chatbot.domain.ChatDomain;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListChatsMapper {

    public static ChatResponse toResponse(ChatDomain entity) {

        return ChatResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
