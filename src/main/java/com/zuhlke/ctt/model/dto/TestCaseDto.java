package com.zuhlke.ctt.model.dto;

import com.zuhlke.ctt.model.entities.TestCase;
import com.zuhlke.ctt.model.enums.TestResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:44 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class TestCaseDto {

    public TestCaseDto(TestCase testCase) {
        this.id = testCase.getId();
        this.name = testCase.getName();
        this.restUrl = testCase.getRestUrl();
        this.expectedResult = testCase.getExpectedResult();
        this.summands = testCase.getSummands();
        this.testSuite = testCase.getTestSuite()!=null ?new TestSuiteDto(testCase.getTestSuite()) : null;
        this.descrption = testCase.getErrorMessage();
        this.lastTestResult = testCase.getLastTestResult();
    }

    private Long id;
    private String name;
    private String restUrl;
    private int expectedResult;
    private List<Integer> summands;
    private TestSuiteDto testSuite;
    private String descrption;
    private TestResult lastTestResult;
}
