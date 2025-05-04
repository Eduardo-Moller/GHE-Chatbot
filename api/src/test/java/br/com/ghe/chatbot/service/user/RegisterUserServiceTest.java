package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.repository.UserRepository;
import br.com.ghe.chatbot.service.user.validators.UniqueEmailValidatorService;
import br.com.ghe.chatbot.service.utilities.NowService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterUserServiceTest {
    @InjectMocks
    private RegisterUserService tested;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UniqueEmailValidatorService uniqueEmailValidatorService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private NowService nowService;

    @Captor
    private ArgumentCaptor<UserDomain> userCaptor;

    @DisplayName("Should create a user successfully when provided with valid data")
    @Test
    void shouldCreateUserSuccessfully_WhenProvidedWithValidData() {
        EasyRandom easyRandom = new EasyRandom();
        RegisterUserRequest request = easyRandom.nextObject(RegisterUserRequest.class);
        LocalDateTime now = easyRandom.nextObject(LocalDateTime.class);

        when(nowService.now()).thenReturn(now);
        when(passwordEncoder.encode(request.getPassword())).thenReturn(request.getPassword());

        tested.register(request);

        verify(uniqueEmailValidatorService).validate(request.getEmail());
        verify(passwordEncoder).encode(request.getPassword());
        verify(nowService).now();
        verify(userRepository).save(userCaptor.capture());
        UserDomain user = userCaptor.getValue();
        assertNotNull(user);
        assertEquals(request.getName(), user.getName());
        assertEquals(request.getEmail(), user.getEmail());
        assertEquals(request.getPassword(), user.getPassword());
        assertEquals(now, user.getCreatedAt());
    }
}