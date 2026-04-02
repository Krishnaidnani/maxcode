package com.example.maxcode.dto.response;

import com.example.maxcode.enums.SubmissionStatus;
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
public class TestCaseResponse {

    private SubmissionStatus status;

    private String input;
    private String expectedOutput;
    private String actualOutput;

    private Integer executionTimeMs;
    private Integer memoryUsedMb;
}
