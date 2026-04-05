package com.example.maxcode.entity;

import com.example.maxcode.enums.ProblemDifficulty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "problems",
        indexes = {
                @Index(name = "idx_problem_difficulty", columnList = "difficulty"),
                @Index(name = "idx_problem_created_at", columnList = "created_at DESC")
        }
)
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_number", unique = true)
    private Integer id;

    @NotNull(message="problem statement cannot be null")
    @Column(name="problem_statement")
    private String problemStatement;

    @NotNull(message = "Time limit is required")
    @Min(value = 1, message = "Time limit must be positive")
    @Column(name = "time_limit_ms", nullable = false)
    private Integer timeLimitMs;

    @NotNull(message = "memory_limit_mb")
    @Column(name = "memory_limit_mb",nullable = false)
    private Integer memory_limit_mb;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "difficulty type cannot be null")
    @Column(name="difficulty",nullable = false)
    private ProblemDifficulty difficulty;

    @Column(name = "examples", columnDefinition = "jsonb")
    private String examples;

    @Column(name="starter_code", columnDefinition = "jsonb")
    private String starter_code;

    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at",nullable = false)
    private LocalDateTime updatedAt;

}
