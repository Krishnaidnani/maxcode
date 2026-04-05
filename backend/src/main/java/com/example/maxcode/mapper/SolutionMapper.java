package com.example.maxcode.mapper;

import com.example.maxcode.dto.request.SolutionRequest;
import com.example.maxcode.dto.response.SolutionResponse;
import com.example.maxcode.entity.Problem;
import com.example.maxcode.entity.Solution;

public class SolutionMapper {

    public static Solution toEntity(SolutionRequest dto, Problem problem) {
        return Solution.builder()
                .problem(problem)
                .language(dto.getLanguage())
                .code(dto.getCode())
                .build();
    }

    public static SolutionResponse toResponse(Solution solution) {
        return SolutionResponse.builder()
                .id(solution.getId())
                .problemId(solution.getProblem().getId())
                .language(solution.getLanguage())
                .code(solution.getCode())
                .build();
    }
}
