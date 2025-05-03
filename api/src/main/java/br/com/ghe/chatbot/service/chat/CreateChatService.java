package br.com.ghe.chatbot.service.chat;

import br.com.ghe.chatbot.controller.dto.request.chat.CreateChatRequest;
import br.com.ghe.chatbot.controller.dto.response.chat.CreatChatResponse;
import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.mapper.chat.CreatChatMapper;
import br.com.ghe.chatbot.repository.ChatRepository;
import br.com.ghe.chatbot.service.user.AuthenticatedUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatService {

    private final AuthenticatedUserService authenticatedUserService;
    private final ChatRepository chatRepository;

    @Transactional
    public CreatChatResponse create(CreateChatRequest request) {

        UserDomain user = authenticatedUserService.get();

        ChatDomain chat = CreatChatMapper.toEntity(user, request);

        chatRepository.save(chat);

        return CreatChatMapper.toResponse(chat);
    }
}
