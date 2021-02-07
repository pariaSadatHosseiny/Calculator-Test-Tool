package com.zuhlke.ctt.service;

import com.zuhlke.ctt.exceptions.RestCustomException;
import com.zuhlke.ctt.model.dto.*;
import com.zuhlke.ctt.model.entities.SummationTest;
import com.zuhlke.ctt.model.entities.TestSuite;
import com.zuhlke.ctt.model.enums.TestResult;
import com.zuhlke.ctt.provider.cmw.client.CmwWebServices;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationRequest;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationResponse;
import com.zuhlke.ctt.repository.TestCaseRepository;
import com.zuhlke.ctt.repository.TestSuiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/*
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:25 PM
 */

/**
 * this is an implementation of SummationTestService and contains services to run a summation Test case
 * with different collection of Integers
 * you can find all test suites and test cases implementations bellow
 *
 * @author p.hosseini
 */
@Service
public class SummationTestServiceImpl implements SummationTestService {

    private final TestCaseRepository testCaseRepository;
    private final TestSuiteRepository testSuiteRepository;
    private final CmwWebServices cmwWebServices;

    public SummationTestServiceImpl(TestCaseRepository testCaseRepository, TestSuiteRepository testSuiteRepository, CmwWebServices cmwWebServices) {
        this.testCaseRepository = testCaseRepository;
        this.testSuiteRepository = testSuiteRepository;
        this.cmwWebServices = cmwWebServices;
    }

    /**
     * <p>runs a single Test Case to test if summation of collection of summands
     * is equal to expected result or Not !!! </p>
     *
     * @param id the id number of test case to run
     * @return the result of running the test - it returns error message if test is failed or faced with error and tes case details
     * @Since 1.0  it added in the first prototype version
     */

    @Override
    public ResponseEntity<RunTestResponseDto> runSingleTestCase(Long id) {
        RunTestResponseDto result = new RunTestResponseDto();

        ////-1  check if test case Exists
        SummationTest summationTest = testCaseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
        ////-2 try to call cmw rest api and compare the result with expected result of test case
        try {
            CmwSummationResponse response = cmwWebServices.summation(new CmwSummationRequest(summationTest.getSummands()));
            // check if result sum is equal to expected sum return success
            if (response.getSum().equals(summationTest.getExpectedResult())) {
                result.setTestResult(TestResult.SUCCESS);
            } else { // check if result sum is not equal to expected sum return failed
                result.setTestResult(TestResult.FAILED);
                result.setMessage(
                        String.format("Test Failed .Expected Result:{} Actual Result:{}", summationTest.getExpectedResult(), response.getSum().toString()));
            }
        } catch (RestCustomException e) { //as handled Exceptions in cmwWebservices it can throw just this kind of Exception
            summationTest.setErrorMessage(e.getMessage());
            summationTest.setLastTestResult(TestResult.ERROR);
            result.setTestResult(TestResult.ERROR);
            result.setMessage(
                    String.format("Test Faced with an Error. please call Customer service to check cause . Details : {}", e.getMessage()));
//            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        result.setTestID(summationTest.getId());
        result.setTestName(summationTest.getName());

        //save new result to test case
        testCaseRepository.save(summationTest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * <p>runs all Test Cases in the specified test suite
     *  and returns a list of test results . this method uses runSingleTestCase method of this class internally </p>
     * @param id the id number of test suite
     * @return the result of running all the test cases as a list of test results with details
     * @Since 1.0  it added in the first prototype version
     */

    @Override
    public ResponseEntity<List<RunTestResponseDto>> runTestSuite(Long id) {
        ////-1  check if test suite Exists
        TestSuite testSuite = testSuiteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find test Suite with mentioned Id"));
        //TODO check if test suite contains zero test case return suitable response to user
        List<RunTestResponseDto> result = new ArrayList<>();
        //TODO can i use streaming here?
        for (SummationTest summationTest : testSuite.getSummationTests()) {
            // call run singleTestCase for each one of tests in test suite
            RunTestResponseDto runSingleTestResult = this.runSingleTestCase(summationTest.getId()).getBody();
            result.add(runSingleTestResult);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TestSuiteDto>> getAllTestSuites() {
        List<TestSuite> alltestSuites = testSuiteRepository.findAll();
        List<TestSuiteDto> testSuiteDtos = alltestSuites.stream().map(objA -> {
            return new TestSuiteDto(objA);
        }).collect(Collectors.toList());

        return new ResponseEntity<>(testSuiteDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() {
        List<SummationTest> allSummationTests = (List<SummationTest>) testCaseRepository.findAll();
        List<TestCaseDto> testCaseDtos = allSummationTests.stream().map(objA -> {
            return new TestCaseDto(objA);
        }).collect(Collectors.toList());

        return new ResponseEntity<>(testCaseDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TestCaseDto> getSingleTestCase(Long id) {
        SummationTest summationTest = testCaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return new ResponseEntity<>(new TestCaseDto(summationTest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TestSuiteDto> getSingleTestSuite(Long id) {
        TestSuite testSuite = testSuiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return new ResponseEntity<>(new TestSuiteDto(testSuite), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TestCaseDto> createNewTestCase(CreateTestCaseRequestDto testCase) {
        return null;
    }

    @Override
    public ResponseEntity<TestSuiteDto> createNewTestSuite(CreateTestSuiteRequestDto testSuite) {
        return null;
    }

    @Override
    public ResponseEntity<TestCaseDto> patchUpdateTestCase(Long id, CreateTestCaseRequestDto testCase) {
        return null;
    }

    @Override
    public ResponseEntity<TestSuiteDto> patchUpdateTestSuite(Long id, CreateTestSuiteRequestDto testSuite) {
        return null;
    }

    @Override
    public ResponseEntity<TestCaseDto> putUpdateTestCase(Long id, CreateTestCaseRequestDto testCase) {
        return null;
    }

    @Override
    public ResponseEntity<TestSuiteDto> putUpdateTestSuite(Long id, CreateTestSuiteRequestDto testSuite) {
        return null;
    }

    @Override
    public ResponseEntity<TestCaseDto> deleteTestCase(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TestSuiteDto> deleteTestSuite(Long id) {
        return null;
    }

}
