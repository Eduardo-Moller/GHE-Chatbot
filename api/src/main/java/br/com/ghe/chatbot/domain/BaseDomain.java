package br.com.ghe.chatbot.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseDomain {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
}
