package br.com.ghe.chatbot.repository;

import br.com.ghe.chatbot.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
    Optional<UserDomain> findByEmail(String email);
    boolean existsByEmailIgnoreCase(String email);
}
