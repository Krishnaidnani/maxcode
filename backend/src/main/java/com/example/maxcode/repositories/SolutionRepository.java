package com.example.maxcode.repositories;

import com.example.maxcode.entity.Solution;
import com.example.maxcode.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Integer> {
    Optional<Solution> findByProblemIdAndLanguage(Integer problemId, Language language);
    List<Solution> findByProblemId(Integer problemId);

}
