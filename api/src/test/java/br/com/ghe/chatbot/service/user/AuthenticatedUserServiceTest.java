package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import static br.com.ghe.chatbot.service.user.TokenService.ID_CLAIM;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticatedUserServiceTest {
    @InjectMocks
    private AuthenticatedUserService tested;

    @Mock
    private UserRepository userRepository;

    @DisplayName("should return the ID of the authenticated user")
    @Test
    void shouldReturnAuthenticatedUserId() {
        Long id = 1L;
        Jwt jwt = mock(Jwt.class);
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        SecurityContextHolder.setContext(securityContext);

        when(jwt.getClaim(ID_CLAIM)).thenReturn(id);
        when(authentication.getCredentials()).thenReturn(jwt);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        Long response = tested.getId();

        assertEquals(id, response);
    }
}