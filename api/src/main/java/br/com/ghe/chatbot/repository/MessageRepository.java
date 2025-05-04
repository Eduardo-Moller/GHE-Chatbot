package br.com.ghe.chatbot.repository;

import br.com.ghe.chatbot.domain.MessageDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageDomain, Long> {}