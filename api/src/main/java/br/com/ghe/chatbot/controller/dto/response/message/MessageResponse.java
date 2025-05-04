package br.com.ghe.chatbot.controller.dto.response.message;

import br.com.ghe.chatbot.enums.TypeEnum;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

    private Long id;
    private String text;
    private TypeEnum type;
    private LocalDateTime createdAt;
}
