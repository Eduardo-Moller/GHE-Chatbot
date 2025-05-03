package br.com.ghe.chatbot.repository;
import br.com.ghe.chatbot.domain.ChatDomain;
import br.com.ghe.chatbot.domain.UserDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatDomain, Long> {

    Page<ChatDomain> findAllByUser(Pageable pageable, UserDomain user);
}
