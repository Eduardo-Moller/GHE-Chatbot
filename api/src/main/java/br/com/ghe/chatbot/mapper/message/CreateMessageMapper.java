package br.com.ghe.chatbot.mapper.message;

import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.MessageDomain;
import br.com.ghe.chatbot.enums.TypeEnum;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateMessageMapper {
    public static MessageDomain toEntity(String text, ChatDomain chat, TypeEnum type) {
        return MessageDomain.builder()
                .text(text)
                .chat(chat)
                .type(type)
                .build();
    }
}
