package br.com.ghe.chatbot.domain;

import br.com.ghe.chatbot.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "message")
public class MessageDomain extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private ChatDomain chat;
}
