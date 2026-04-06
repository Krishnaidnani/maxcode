package com.example.maxcode.mapper;

import com.example.maxcode.dto.request.SubmissionRequest;
import com.example.maxcode.dto.response.SubmissionResponse;
import com.example.maxcode.entity.Problem;
import com.example.maxcode.entity.Submission;
import com.example.maxcode.entity.User;
import com.example.maxcode.enums.SubmissionStatus;

public class SubmissionMapper {

    public static Submission toEntity(SubmissionRequest dto, User user, Problem problem) {
        return Submission.builder()
                .user(user)
                .problem(problem)
                .language(dto.getLanguage())
                .code(dto.getCode())
                .status(SubmissionStatus.PENDING)
                .runtime_ms(0)
                .memory_used_mb(0)
                .build();
    }

    public static SubmissionResponse toResponse(Submission submission) {
        return SubmissionResponse.builder()
                .id(submission.getId())
                .userId(submission.getUser().getId())
                .problemId(submission.getProblem().getId())
                .language(submission.getLanguage())
                .code(submission.getCode())
                .status(submission.getStatus())
                .runtimeMs(submission.getRuntime_ms())
                .memoryUsedMb(submission.getMemory_used_mb())
                .timestamp(submission.getTimestamp())
                .build();
    }
}
