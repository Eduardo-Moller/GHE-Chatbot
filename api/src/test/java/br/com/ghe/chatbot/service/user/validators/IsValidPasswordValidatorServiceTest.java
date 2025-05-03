package br.com.ghe.chatbot.service.user.validators;

import br.com.ghe.chatbot.domain.UserDomain;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IsValidPasswordValidatorServiceTest {
    @InjectMocks
    private IsValidPasswordValidatorService tested;

    @Mock
    private PasswordEncoder passwordEncoder;

    @DisplayName("should validate password when it is valid")
    @Test
    void shouldValidatePasswordWhenItIsValid() {
        EasyRandom easyRandom = new EasyRandom();
        String password = "password";
        UserDomain user = easyRandom.nextObject(UserDomain.class);

        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);

        assertDoesNotThrow(() -> tested.validate(password, user));
        verify(passwordEncoder).matches(password, user.getPassword());
    }

    @DisplayName("should throw exception when password is not valid")
    @Test
    void shouldThrowExceptionWhenPasswordIsNotValid() {
        EasyRandom easyRandom = new EasyRandom();
        String password = "password";
        UserDomain user = easyRandom.nextObject(UserDomain.class);

        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(false);

        assertThrows(BadCredentialsException.class, () -> tested.validate(password, user));
        verify(passwordEncoder).matches(password, user.getPassword());
    }
}