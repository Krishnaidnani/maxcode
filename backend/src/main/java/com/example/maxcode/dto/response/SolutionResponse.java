package com.example.maxcode.dto.response;

import com.example.maxcode.enums.Language;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolutionResponse {

    private Integer id;
    private Integer problemId;
    private Language language;
    private String code;
}
