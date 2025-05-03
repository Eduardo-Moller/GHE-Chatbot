package br.com.ghe.chatbot.controller.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    @NotBlank
    @Email
    @Size(max = 255, message = "Deve conter um email válido")
    private String email;

    @NotBlank
    @Size(max = 255, min = 6, message = "Deve conter no mínimo 6 caracteres")
    private String password;
}
