package com.example.maxcode.entity;

import com.example.maxcode.enums.Language;
import com.example.maxcode.enums.SubmissionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name="Submission", indexes = {
        @Index(
                name = "idx_user_problem_created",
                columnList = "user_id, problem_id, timestamp DESC"
        ),
        @Index(name = "idx_user", columnList = "user_id")
})
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="problem_id",nullable = false)
    private Problem problem;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="language",nullable = false)
    private Language language;

    @NotNull(message = "code cannot be null")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false)
    private SubmissionStatus status;

    @Min(value = 1, message = "Time limit must be positive")
    @Column(name = "runtime_ms")
    private Integer runtime_ms;

    @Column(name = "memory_used_mb")
    private Integer memory_used_mb;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime timestamp;
}
