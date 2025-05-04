package br.com.ghe.chatbot.mapper.message;

import br.com.ghe.chatbot.controller.dto.response.message.MessageResponse;
import br.com.ghe.chatbot.domain.MessageDomain;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageMapper {
    public static MessageResponse toResponse(MessageDomain entity) {
        return MessageResponse.builder()
                .id(entity.getId())
                .text(entity.getText())
                .type(entity.getType())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
