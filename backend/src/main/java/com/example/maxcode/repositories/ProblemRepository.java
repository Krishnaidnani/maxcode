package com.example.maxcode.repositories;

import com.example.maxcode.entity.Problem;
import com.example.maxcode.enums.ProblemDifficulty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {
    Page<Problem> findByDifficulty(ProblemDifficulty difficulty, Pageable pageable);
    Page<Problem> findByProblemStatementContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Problem> findByDifficultyAndProblemStatementContainingIgnoreCase(
            ProblemDifficulty difficulty,
            String keyword,
            Pageable pageable
    );

    List<Problem> findTop10ByOrderByCreatedAtDesc();
}
