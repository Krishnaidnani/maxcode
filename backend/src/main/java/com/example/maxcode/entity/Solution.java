package com.example.maxcode.entity;


import com.example.maxcode.enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "solutions",
        indexes = {
                @Index(name = "idx_solution_problem", columnList = "problem_id"),
                @Index(name = "idx_solution_problem_language", columnList = "problem_id, language")
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_problem_language_solution",
                        columnNames = {"problem_id", "language"}
                )
        }
)
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Language language;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String code;


}
