package br.com.ghe.chatbot.service.message;

import br.com.ghe.chatbot.controller.dto.request.message.MessageCreateRequest;
import br.com.ghe.chatbot.controller.dto.response.message.MessageResponse;
import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.MessageDomain;
import br.com.ghe.chatbot.enums.TypeEnum;
import br.com.ghe.chatbot.mapper.message.MessageMapper;
import br.com.ghe.chatbot.repository.MessageRepository;
import br.com.ghe.chatbot.service.chat.search.SearchChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static br.com.ghe.chatbot.mapper.message.CreateMessageMapper.toEntity;

@Service
@RequiredArgsConstructor
public class CreateMessageService {
    private final PromptMessageService promptMessageService;
    private final SearchChatService searchChatService;
    private final MessageRepository messageRepository;

    @Transactional
    public List<MessageResponse> create(MessageCreateRequest request) {

        ChatDomain chat = searchChatService.findById(request.getChatId());

        String completition = promptMessageService.completion(request.getText());

        List<MessageDomain> messages = new ArrayList<>();
        messages.add(toEntity(request.getText(), chat, TypeEnum.USER));
        messages.add(toEntity(completition, chat, TypeEnum.BOT));

        messageRepository.saveAll(messages);

        return messages
                .stream()
                .map(MessageMapper::toResponse)
                .toList();
    }
}
