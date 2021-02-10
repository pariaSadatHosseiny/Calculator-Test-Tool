package com.zuhlke.ctt.model.dto;

import com.zuhlke.ctt.model.enums.TestResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       9:55 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RunTestDto {
    private Long testID;
    private String testName;
    private TestResult testResult;
    private String message;
}
