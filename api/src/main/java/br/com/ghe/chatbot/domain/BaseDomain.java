package br.com.ghe.chatbot.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseDomain {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

    @PrePersist
    private void prePersist() {
        this.createdAt = now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = now();
    }
}
