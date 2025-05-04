package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.controller.dto.request.user.LoginRequest;
import br.com.ghe.chatbot.controller.dto.response.user.LoginResponse;
import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.service.user.search.SearchUserService;
import br.com.ghe.chatbot.service.user.validators.IsValidPasswordValidatorService;
import org.jeasy.random.EasyRandom;
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
class LoginServiceTest {
    @InjectMocks
    private LoginService tested;

    @Mock
    private SearchUserService searchUserService;

    @Mock
    private TokenService tokenService;

    @Mock
    private IsValidPasswordValidatorService isValidPasswordValidatorService;

    @DisplayName("Should login successfully when provided with valid credentials")
    @Test
    void shouldLoginSuccessfully_WhenProvidedWithValidCredentials() {
        EasyRandom easyRandom = new EasyRandom();
        LoginRequest request = easyRandom.nextObject(LoginRequest.class);
        UserDomain user = easyRandom.nextObject(UserDomain.class);
        String accessToken = easyRandom.nextObject(String.class);

        when(searchUserService.findByEmail(request.getEmail())).thenReturn(user);
        when(tokenService.createToken(user)).thenReturn(accessToken);

        LoginResponse response = tested.login(request);

        verify(searchUserService).findByEmail(request.getEmail());
        verify(isValidPasswordValidatorService).validate(request.getPassword(), user);
        verify(tokenService).createToken(user);
        assertEquals(accessToken, response.getAccessToken());
    }
}