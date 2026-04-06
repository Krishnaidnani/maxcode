package com.example.maxcode.repositories;

import com.example.maxcode.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findByProblemIdOrderByOrderIndexAsc(Integer problemId);

    List<TestCase> findByProblemIdAndIsHiddenFalseOrderByOrderIndexAsc(Integer problemId);

    List<TestCase> findByProblemIdAndIsHiddenTrueOrderByOrderIndexAsc(Integer problemId);

    Integer countByProblemId(Integer problemId);
}
