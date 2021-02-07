package com.zuhlke.ctt.model.dto;

import com.zuhlke.ctt.model.entities.SummationTest;
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

    public TestCaseDto(SummationTest summationTest) {
        this.id = summationTest.getId();
        this.name = summationTest.getName();
       // this.restUrl = summationTest.getRestUrl();
        this.expectedResult = summationTest.getExpectedResult();
        this.summands = summationTest.getSummands();
        this.testSuite = summationTest.getTestSuite()!=null ?new TestSuiteDto(summationTest.getTestSuite()) : null;
        this.descrption = summationTest.getErrorMessage();
        this.lastTestResult = summationTest.getLastTestResult();
    }

    private Long id;
    private String name;
    //private String restUrl;
    private int expectedResult;
    private List<Integer> summands;
    private TestSuiteDto testSuite;
    private String descrption;
    private TestResult lastTestResult;
}
