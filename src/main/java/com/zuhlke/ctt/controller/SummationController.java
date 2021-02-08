package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.*;
import com.zuhlke.ctt.service.SummationTestService;
import com.zuhlke.ctt.service.TestCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       9:11 PM
 */

@RestController
@RequestMapping(path = {"/api/v1/summation/"}, produces = APPLICATION_JSON_VALUE)
public class SummationController {

    private static final Logger logger = LoggerFactory.getLogger(SummationController.class);
    private final TestCaseService testCaseService;
    private final SummationTestService summationTestService;

    public SummationController(@Qualifier("SummationTestService") TestCaseService testCaseService, SummationTestService summationTestService) {
        this.testCaseService = testCaseService;
        this.summationTestService = summationTestService;
    }


    @RequestMapping(value = "testCases/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<RunTestDto> runSingleTestCase(@PathVariable Long id) throws Throwable {
        return testCaseService.runSingleTestCase(id);
    }
    @RequestMapping(value = "testSuites/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RunTestDto>> runTestSuite(@PathVariable Long id) throws Throwable {
        return testCaseService.runTestSuite(id);
    }


    @RequestMapping(value = "testCases", method = RequestMethod.GET)
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() throws Throwable {
        return summationTestService.getAllTestCases();
    }


    @RequestMapping(value = "testSuites", method = RequestMethod.GET)
    public ResponseEntity<List<TestSuiteDto>> getAllTestSuites() throws Throwable {
        return summationTestService.getAllTestSuites();
    }

    @RequestMapping(value = "testCases/{id}", method = RequestMethod.GET)
    public ResponseEntity<TestCaseDto> getSingleTestCase(@PathVariable Long id) throws Throwable {
        return summationTestService.getSingleTestCase(id);
    }
    @RequestMapping(value = "testSuites/{id}", method = RequestMethod.GET)
    public ResponseEntity<TestSuiteDto> getSingleTestSuite(@PathVariable Long id) throws Throwable {
        return summationTestService.getSingleTestSuite(id);
    }


    @RequestMapping(value = "testCases", method = RequestMethod.POST)
    public ResponseEntity<TestCaseDto> createTestCase(@RequestBody CreateTestCaseDto testCase) {
        return summationTestService.createNewTestCase(testCase);
    }

    @RequestMapping(value = "testSuites", method = RequestMethod.POST)
    public ResponseEntity<TestSuiteDto> createTestSuite(@RequestBody CreateTestSuiteDto testSuite) {
        return summationTestService.createNewTestSuite(testSuite);
    }


    @RequestMapping(value = "testCases/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<TestCaseDto> patchUpdateTestCase(@PathVariable Long id, @RequestBody CreateTestCaseDto testCase) {
        return summationTestService.patchUpdateTestCase(id, testCase);
    }


    @RequestMapping(value = "testSuites/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<TestSuiteDto> patchUpdateTestSuite(@PathVariable Long id, @RequestBody CreateTestSuiteDto testSuite) {
        return summationTestService.patchUpdateTestSuite(id, testSuite);
    }


    @RequestMapping(value = "testCases/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TestCaseDto> putUpdateTestCase(@PathVariable Long id, @RequestBody CreateTestCaseDto testCase) {
        return summationTestService.putUpdateTestCase(id, testCase);
    }


    @RequestMapping(value = "testSuites/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TestSuiteDto> putUpdateTestSuite(@PathVariable Long id, @RequestBody CreateTestSuiteDto testSuite) {
        return summationTestService.putUpdateTestSuite(id, testSuite);
    }


    @RequestMapping(value = "testCases/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TestCaseDto> deleteTestCase(@PathVariable Long id) {
        return summationTestService.deleteTestCase(id);
    }

    @RequestMapping(value = "testSuites/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TestSuiteDto> deleteTestSuite(@PathVariable Long id) {
        return summationTestService.deleteTestSuite(id);
    }

}

