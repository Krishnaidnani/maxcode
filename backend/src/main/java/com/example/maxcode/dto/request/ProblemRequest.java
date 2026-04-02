package com.example.maxcode.dto.request;

import com.example.maxcode.enums.ProblemDifficulty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemRequest{

    @NotNull(message="Problem statement cannot be null")
    private String problemStatement;

    @NotNull(message="Time limit is required")
    @Min(value = 1, message="Time limit must be positive")
    private Integer timeLimitMs;

    @NotNull(message="Memory limit is required")
    @Min(value = 1, message="Memory limit must be positive")
    private Integer memoryLimitMb;

    @NotNull(message="Difficulty cannot be null")
    private ProblemDifficulty difficulty;

    private List<Map<String, String>> examples;

    private List<Map<String, String>> starterCode;
}
