package com.example.maxcode.dto.response;

import com.example.maxcode.entity.ProblemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemStatusResponse {
    private Integer id;
    private Integer userId;
    private Integer problemId;
    private ProblemStatus status;
    private Integer lastSubmissionId;
}
