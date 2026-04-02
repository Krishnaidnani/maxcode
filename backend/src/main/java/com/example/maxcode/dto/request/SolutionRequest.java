package com.example.maxcode.dto.request;

import com.example.maxcode.enums.Language;
import jakarta.validation.constraints.NotBlank;
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
public class SolutionRequest {

        @NotNull(message = "Problem ID is required")
        private Integer problemId;

        @NotNull(message = "Language is required")
        private Language language;

        @NotBlank(message = "Code cannot be empty")
        private String code;
    }
