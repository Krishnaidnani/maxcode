package com.example.maxcode.dto.response;

import com.example.maxcode.enums.Language;
import com.example.maxcode.enums.SubmissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmissionResponse {

    private Integer id;
    private Integer userId;
    private Integer problemId;
    private Language language;
    private String code;
    private SubmissionStatus status;
    private Integer runtimeMs;
    private Integer memoryUsedMb;
    private LocalDateTime timestamp;
}