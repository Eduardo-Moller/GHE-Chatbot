package br.com.ghe.chatbot.controller;

import br.com.ghe.chatbot.controller.dto.request.chat.CreateChatRequest;
import br.com.ghe.chatbot.controller.dto.response.chat.ChatResponse;
import br.com.ghe.chatbot.controller.dto.response.chat.CreateChatResponse;
import br.com.ghe.chatbot.service.chat.CreateChatService;
import br.com.ghe.chatbot.service.chat.ListChatsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {

    private final CreateChatService createChatService;
    private final ListChatsService listChatsService;

    @PostMapping
    public CreateChatResponse create(@Valid @RequestBody CreateChatRequest request){
        return createChatService.create(request);
    }

    @GetMapping("/me")
    public Page<ChatResponse> list(Pageable pageable){
        return listChatsService.list(pageable);
    }
}
