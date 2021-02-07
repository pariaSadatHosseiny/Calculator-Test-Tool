package com.zuhlke.ctt.model.dto;

import com.zuhlke.ctt.model.enums.TestResult;
import lombok.Data;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       9:55 PM
 */
@Data
public class RunTestResponseDto {
    private Long testID;
    private String testName;
    private TestResult testResult;
    private String message;
}
