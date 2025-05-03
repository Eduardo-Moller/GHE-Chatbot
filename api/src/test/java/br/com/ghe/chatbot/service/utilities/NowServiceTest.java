package br.com.ghe.chatbot.service.utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NowServiceTest {
    @InjectMocks
    private NowService tested;

    @DisplayName("should return the current date and time")
    @Test
    void shouldReturnCurrentDateAndTime() {
        LocalDateTime response = tested.now();

        assertNotNull(response);
    }
}