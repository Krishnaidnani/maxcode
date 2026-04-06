package com.example.maxcode.repositories;

import com.example.maxcode.entity.Submission;
import com.example.maxcode.enums.SubmissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Integer> {
    Page<Submission> findByUserIdAndProblemId(
            Integer userId,
            Integer problemId,
            Pageable pageable
    );
    Optional<Submission> findTopByUserIdAndProblemIdOrderByTimestampDesc(
            Integer userId,
            Integer problemId
    );
    Optional<Submission> findTopByUserIdAndProblemIdAndStatusOrderByTimestampDesc(
            Integer userId,
            Integer problemId,
            SubmissionStatus status
    );

}
