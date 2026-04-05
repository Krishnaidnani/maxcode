package com.example.maxcode.mapper;

import com.example.maxcode.dto.request.TestCaseRequest;
import com.example.maxcode.dto.response.TestCaseResponse;
import com.example.maxcode.entity.Problem;
import com.example.maxcode.entity.TestCase;
import com.example.maxcode.enums.SubmissionStatus;

public class TestMapper {

    public static TestCase toEntity(TestCaseRequest request, Problem problem) {

        return TestCase.builder()
                .problem(problem)
                .inputFilePath(request.getInputFilePath())
                .outputFilePath(request.getOutputFilePath())
                .isHidden(request.getIsHidden())
                .orderIndex(request.getOrderIndex())
                .build();
    }

    public static TestCaseResponse toFailureResponse(
            SubmissionStatus status,
            String input,
            String expectedOutput,
            String actualOutput,
            Integer executionTimeMs,
            Integer memoryUsedMb
    ) {
        return TestCaseResponse.builder()
                .status(status)
                .input(input)
                .expectedOutput(expectedOutput)
                .actualOutput(actualOutput)
                .executionTimeMs(executionTimeMs)
                .memoryUsedMb(memoryUsedMb)
                .build();
    }
    public static TestCaseResponse toSuccessResponse(
            Integer executionTimeMs,
            Integer memoryUsedMb
    ) {
        return TestCaseResponse.builder()
                .status(SubmissionStatus.ACCEPTED)
                .executionTimeMs(executionTimeMs)
                .memoryUsedMb(memoryUsedMb)
                .build();
    }
}