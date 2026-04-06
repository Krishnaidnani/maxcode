package com.example.maxcode.repositories;

import com.example.maxcode.entity.Problem;
import com.example.maxcode.entity.ProblemStatus;
import com.example.maxcode.entity.User;
import com.example.maxcode.enums.ProblemStatusType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProblemStatusRepository extends JpaRepository<ProblemStatus, Integer> {
    Optional<ProblemStatus> findByUserIdAndProblemId(Integer userId, Integer problemId);
    Page<ProblemStatus> findByUser(User user, Pageable pageable);

    Page<ProblemStatus> findByUserAndStatus(User user, ProblemStatusType status, Pageable pageable);

}
