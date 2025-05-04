package br.com.ghe.chatbot.service.chat.search;

import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.exception.ResourceNotFound;
import br.com.ghe.chatbot.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchChatService {

    private final ChatRepository chatRepository;

    public ChatDomain findById(Long id) {
        return chatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Chat não encontrado"));
    }
}
