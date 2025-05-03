package br.com.ghe.chatbot.service.chat;

import br.com.ghe.chatbot.controller.dto.response.chat.ChatResponse;
import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.mapper.chat.ListChatsMapper;
import br.com.ghe.chatbot.repository.ChatRepository;
import br.com.ghe.chatbot.service.user.AuthenticatedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListChatsService {

    private final ChatRepository chatRepository;
    private final AuthenticatedUserService authenticatedUserService;

    public Page<ChatResponse> list(Pageable pageable) {

        UserDomain user = authenticatedUserService.get();

        return chatRepository.findAllByUser( pageable, user).map(ListChatsMapper::toResponse);
    }
}
