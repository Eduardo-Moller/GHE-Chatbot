package br.com.ghe.chatbot.service.user.validators;

import br.com.ghe.chatbot.exception.InvalidFieldException;
import br.com.ghe.chatbot.service.user.search.SearchUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UniqueEmailValidatorServiceTest {
    @InjectMocks
    private UniqueEmailValidatorService tested;

    @Mock
    private SearchUserService searchUserService;

    @DisplayName("should validate email when it is unique")
    @Test
    void shouldValidateEmailWhenItIsUnique() {
        String email = "email@example.com.br";

        when(searchUserService.existsByEmail(email)).thenReturn(false);

        tested.validate(email);

        verify(searchUserService).existsByEmail(email);
        assertDoesNotThrow(() -> tested.validate(email));
    }

    @DisplayName("should throw exception when email is not unique")
    @Test
    void shouldThrowExceptionWhenEmailIsNotUnique() {
        String email = "email@example.com.br";

        when(searchUserService.existsByEmail(email)).thenReturn(true);

        assertThrows(InvalidFieldException.class, () -> tested.validate(email));
        verify(searchUserService).existsByEmail(email);
    }
}