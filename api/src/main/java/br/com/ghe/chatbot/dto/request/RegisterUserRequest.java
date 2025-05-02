package br.com.ghe.chatbot.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 255)
    private String password;
}
