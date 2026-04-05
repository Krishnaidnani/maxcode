package com.example.maxcode.dto.response;

import com.example.maxcode.enums.ProblemDifficulty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemResponse {

    private Integer id;
    private String problemStatement;
    private Integer timeLimitMs;
    private Integer memoryLimitMb;
    private ProblemDifficulty difficulty;
    private List<Map<String, String>> examples;
    private List<Map<String, String>> starterCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}