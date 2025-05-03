package br.com.ghe.chatbot.service.user.search;

import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.exception.ResourceNotFound;
import br.com.ghe.chatbot.repository.UserRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchUserServiceTest {
    @InjectMocks
    private SearchUserService tested;

    @Mock
    private UserRepository userRepository;

    @DisplayName("Should retrieve user successfully when email exists")
    @Test
    void shouldRetrieveUserWhenEmailExists() {
        EasyRandom easyRandom = new EasyRandom();
        UserDomain user = easyRandom.nextObject(UserDomain.class);
        String email = "email@example.com.br";

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        UserDomain response = tested.findByEmail(email);

        verify(userRepository).findByEmail(email);
        assertEquals(user.getId(), response.getId());
        assertEquals(user.getName(), response.getName());
        assertEquals(user.getEmail(), response.getEmail());
        assertEquals(user.getPassword(), response.getPassword());
    }

    @DisplayName("Should throw ResourceNotFound exception when email does not exist")
    @Test
    void shouldThrowResourceNotFoundWhenEmailDoesNotExist() {
        String email = "email@example.com.br";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> tested.findByEmail(email));
        verify(userRepository).findByEmail(email);
    }

    @DisplayName("Should return true when email exists")
    @Test
    void shouldReturnTrueWhenEmailExists() {
        String email = "email@example.com.br";

        when(userRepository.existsByEmailIgnoreCase(email)).thenReturn(true);

        boolean response = tested.existsByEmail(email);

        verify(userRepository).existsByEmailIgnoreCase(email);
        assertTrue(response);
    }

    @DisplayName("Should return false when email does not exist")
    @Test
    void shouldReturnFalseWhenEmailDoesNotExist() {
        String email = "email@example.com.br";

        when(userRepository.existsByEmailIgnoreCase(email)).thenReturn(false);

        boolean response = tested.existsByEmail(email);

        verify(userRepository).existsByEmailIgnoreCase(email);
        assertFalse(response);
    }
}