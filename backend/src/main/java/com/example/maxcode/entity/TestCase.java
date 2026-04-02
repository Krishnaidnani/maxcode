package com.example.maxcode.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "test_cases",
        indexes = {
                @Index(name = "idx_testcase_problem_id", columnList = "problem_id"),
                @Index(name = "idx_testcase_order", columnList = "problem_id, order_index")
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_problem_order",
                        columnNames = {"problem_id", "order_index"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @NotBlank
    @Column(name = "input_file_path", nullable = false, length = 500)
    private String inputFilePath;

    @NotBlank
    @Column(name = "output_file_path", nullable = false, length = 500)
    private String outputFilePath;

    @NotNull
    @Column(name = "is_hidden", nullable = false)
    private Boolean isHidden = false;

    @NotNull
    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;
}