package br.com.ghe.chatbot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "chat")
public class ChatDomain extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDomain user;

    @OneToMany(mappedBy = "chat")
    private List<MessageDomain> messages;
}
