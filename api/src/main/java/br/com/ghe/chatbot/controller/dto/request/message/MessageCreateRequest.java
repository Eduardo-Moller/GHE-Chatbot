package br.com.ghe.chatbot.controller.dto.request.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
public class MessageCreateRequest {

    @NotNull(message = "O chatId não pode ser nulo")
    private Long chatId;

    @NotBlank(message = "O texto não pode ser vazio ou nulo")
    @Size(max = 200, min = 2, message = "O texto deve ter entre 2 e 200 caracteres")
    private String text;
}
