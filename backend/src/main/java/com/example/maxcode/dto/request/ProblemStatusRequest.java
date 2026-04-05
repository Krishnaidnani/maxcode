package com.example.maxcode.dto.request;

import com.example.maxcode.entity.ProblemStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemStatusRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer problemId;

    @NotNull
    private ProblemStatus status;

    private Integer lastSubmissionId;
}
