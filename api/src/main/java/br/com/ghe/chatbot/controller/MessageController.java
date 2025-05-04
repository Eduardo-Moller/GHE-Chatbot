package br.com.ghe.chatbot.controller;

import br.com.ghe.chatbot.controller.dto.request.message.MessageCreateRequest;
import br.com.ghe.chatbot.controller.dto.response.message.MessageResponse;
import br.com.ghe.chatbot.service.message.CreateMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final CreateMessageService createMessageService;

    @PostMapping
    @ResponseStatus(CREATED)
    public List<MessageResponse> create(@Valid @RequestBody MessageCreateRequest request) {
        return createMessageService.create(request);
    }

    @GetMapping("/{chatId}")
    public List<MessageResponse> list(@RequestParam Long chatId) {
        return null;
    }
}
