package com.example.maxcode.mapper;

import com.example.maxcode.dto.request.ProblemStatusRequest;
import com.example.maxcode.dto.response.ProblemStatusResponse;
import com.example.maxcode.entity.ProblemStatus;

public class ProblemStatusMapper {
    public static ProblemStatus toEntity(ProblemStatusRequest request){
        ProblemStatus problemStatus=ProblemStatus.builder()
                .problem(request.getStatus().getProblem())
                .user(request.getStatus().getUser())
                .status(request.getStatus())
                .lastSubmissionId(request.getLastSubmissionId())
                .build();

        return problemStatus;
    }

    public static ProblemStatusResponse toResponse(ProblemStatus entity) {
        return ProblemStatusResponse.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .problemId(entity.getProblem().getId())
                .status(entity.getStatus())
                .lastSubmissionId(entity.getLastSubmissionId())
                .build();
    }
}
