package br.com.ghe.chatbot.controller.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequest {

    @NotBlank
    @Size(max = 100, min = 3, message = "Deve ter entre 3 e 100 caracteres")
    private String name;

    @Email
    @NotBlank
    @Size(max = 255, min = 3, message = "Deve ter entre 3 e 255 caracteres")
    private String email;

    @NotBlank
    @Size(max = 255, min = 6, message = "Deve conter no mínimo 6 caracteres")
    private String password;
}
