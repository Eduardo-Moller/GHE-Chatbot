package br.com.ghe.chatbot.service.utilities;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NowService {
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
