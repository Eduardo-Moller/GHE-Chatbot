package br.com.ghe.chatbot.controller;

import br.com.ghe.chatbot.controller.dto.request.CreateChatRequest;
import br.com.ghe.chatbot.controller.dto.response.CreatChatResponse;
import br.com.ghe.chatbot.service.chat.CreateChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {

    private final CreateChatService createChatService;

    @PostMapping
    public CreatChatResponse create(@Valid @RequestBody CreateChatRequest request){
        return createChatService.create(request);
    }
}
