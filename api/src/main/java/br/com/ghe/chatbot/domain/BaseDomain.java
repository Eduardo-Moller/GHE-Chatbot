package br.com.ghe.chatbot.domain;

import br.com.ghe.chatbot.service.utilities.NowService;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static br.com.ghe.chatbot.service.utilities.NowService.*;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseDomain {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

    @PrePersist
    private void prePersist() {
        this.createdAt = now().plusDays(2L);
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = now();
    }
}
