package br.com.ghe.chatbot.repository;

import br.com.ghe.chatbot.domain.ChatDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatDomain, Long> {
}
