package com.example.maxcode.dto.request;

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
public class TestCaseRequest {

    @NotNull(message = "Problem ID is required")
    private Integer problemId;

    @NotBlank(message = "Input file path cannot be empty")
    private String inputFilePath;

    @NotBlank(message = "Output file path cannot be empty")
    private String outputFilePath;

    @NotNull(message = "isHidden flag is required")
    private Boolean isHidden;

    @NotNull(message = "Order index is required")
    private Integer orderIndex;
}
