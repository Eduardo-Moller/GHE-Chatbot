package br.com.ghe.chatbot.domain;

import br.com.ghe.chatbot.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MessageDomain extends BaseDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private TypeEnum type;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private ChatDomain chat;
}
