package com.example.maxcode.mapper;

import com.example.maxcode.dto.request.ProblemRequest;
import com.example.maxcode.dto.response.ProblemResponse;
import com.example.maxcode.entity.Problem;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class ProblemMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Problem toEntity(ProblemRequest dto) {
        Problem problem = Problem.builder()
                .problemStatement(dto.getProblemStatement())
                .timeLimitMs(dto.getTimeLimitMs())
                .memory_limit_mb(dto.getMemoryLimitMb())
                .difficulty(dto.getDifficulty())
                .createdAt(java.time.LocalDateTime.now())
                .updatedAt(java.time.LocalDateTime.now())
                .build();

        try {
            if (dto.getExamples() != null) {
                problem.setExamples(objectMapper.writeValueAsString(dto.getExamples()));
            }
            if (dto.getStarterCode() != null) {
                problem.setStarter_code(objectMapper.writeValueAsString(dto.getStarterCode()));
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to convert examples/starterCode to JSON", e);
        }

        return problem;
    }
    public static ProblemResponse toResponse(Problem problem) {
        ProblemResponse.ProblemResponseBuilder builder = ProblemResponse.builder()
                .id(problem.getId())
                .problemStatement(problem.getProblemStatement())
                .timeLimitMs(problem.getTimeLimitMs())
                .memoryLimitMb(problem.getMemory_limit_mb())
                .difficulty(problem.getDifficulty())
                .createdAt(problem.getCreatedAt())
                .updatedAt(problem.getUpdatedAt());

        try {
            if (problem.getExamples() != null) {
                List<Map<String, String>> examples = objectMapper.readValue(problem.getExamples(), List.class);
                builder.examples(examples);
            }
            if (problem.getStarter_code() != null) {
                List<Map<String, String>> starterCode = objectMapper.readValue(problem.getStarter_code(), List.class);
                builder.starterCode(starterCode);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to parse JSON for examples/starterCode", e);
        }

        return builder.build();
    }
}
