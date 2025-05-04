package br.com.ghe.chatbot.service.chat;

import br.com.ghe.chatbot.controller.dto.request.chat.CreateChatRequest;
import br.com.ghe.chatbot.controller.dto.response.chat.CreateChatResponse;
import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.mapper.chat.CreateChatMapper;
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
    public CreateChatResponse create(CreateChatRequest request) {

        UserDomain user = authenticatedUserService.get();

        ChatDomain chat = CreateChatMapper.toEntity(user, request);

        chatRepository.save(chat);

        return CreateChatMapper.toResponse(chat);
    }
}
