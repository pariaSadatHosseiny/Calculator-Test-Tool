package com.zuhlke.ctt.service;

import com.zuhlke.ctt.controller.SummationController;
import com.zuhlke.ctt.exceptions.RestCustomException;
import com.zuhlke.ctt.model.dto.*;
import com.zuhlke.ctt.model.entities.SummationTest;
import com.zuhlke.ctt.model.entities.TestSuite;
import com.zuhlke.ctt.model.enums.TestResult;
import com.zuhlke.ctt.provider.cmw.client.CmwWebServices;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationRequest;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationResponse;
import com.zuhlke.ctt.repository.SummationTestRepository;
import com.zuhlke.ctt.repository.TestSuiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
@Service("SummationTestService")
public class SummationTestServiceImpl implements TestCaseService {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SummationTestRepository summationTestRepository;
    private final TestSuiteRepository testSuiteRepository;
    private final CmwWebServices cmwWebServices;

    public SummationTestServiceImpl(SummationTestRepository summationTestRepository, TestSuiteRepository testSuiteRepository, CmwWebServices cmwWebServices) {
        this.summationTestRepository = summationTestRepository;
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
    public ResponseEntity<RunTestDto> runSingleTestCase(Long id) {
        logger.debug("runSingleTestCase => called for id :{} ",id);
        RunTestDto result = new RunTestDto();

        ////-1  check if test case Exists
        Optional<SummationTest> summationTestResp = summationTestRepository.findById(id);
        if(!summationTestResp.isPresent()) {
            logger.error("runSingleTestCase => test case does not exist :{} ",id);
            throw new ResponseStatusException(NOT_FOUND, "Unable to find test case");
        }
        SummationTest summationTest  = summationTestResp.get();
        ////-2 try to call cmw rest api and compare the result with expected result of test case
        try {
            CmwSummationResponse response = cmwWebServices.summation(new CmwSummationRequest(summationTest.getSummands()));
            // check if result sum is equal to expected sum return success
            if (response.getSum().equals(summationTest.getExpectedResult())) {
                result.setTestResult(TestResult.SUCCESS);
            } else { // check if result sum is not equal to expected sum return failed
                result.setTestResult(TestResult.FAILED);
                result.setMessage(
                        String.format("Test Failed .Expected Result:%s Actual Result:%s", summationTest.getExpectedResult(), response.getSum().toString()));
            }
        } catch (RestCustomException e) { //as handled Exceptions in cmwWebservices it can throw just this kind of Exception
            logger.error("runSingleTestCase => exception on calling cmw service for id:{} exception :{} ",id,e);
            summationTest.setErrorMessage(e.getMessage());
            summationTest.setLastTestResult(TestResult.ERROR);
            result.setTestResult(TestResult.ERROR);
            result.setMessage(
                    String.format("Test Faced with an Error. please call Customer service to check cause . Details : %s", e.getMessage()));
        }
        result.setTestID(summationTest.getId());
        result.setTestName(summationTest.getName());

        //save new result to test case
        summationTestRepository.save(summationTest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
///--------------------------------------------------------------------------------------------------------------------------

    /**
     * <p>runs all Test Cases in the specified test suite
     * and returns a list of test results . this method uses runSingleTestCase method of this class internally </p>
     *
     * @param id the id number of test suite
     * @return the result of running all the test cases as a list of test results with details
     * @Since 1.0  it added in the first prototype version
     */

    @Override
    public ResponseEntity<List<RunTestDto>> runTestSuite(Long id) {
        ////-1  check if test suite Exists
        Optional<TestSuite> testSuiteRep = testSuiteRepository.findById(id);
        if(!testSuiteRep.isPresent())
            throw new ResponseStatusException(NOT_FOUND, "Unable to find test Suite with mentioned Id");

        // check if test suite contains zero test case return suitable response to user
        TestSuite testSuite = testSuiteRep.get();
        if(testSuite.getSummationTests()==null || testSuite.getSummationTests().isEmpty())
            throw new ResponseStatusException(NOT_FOUND , "there is no test case for this test suite");

        List<RunTestDto> result = new ArrayList<>();
        testSuite.getSummationTests()
                .forEach((test) -> result.add(this.runSingleTestCase(test.getId()).getBody()));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
///--------------------------------------------------------------------------------------------------------------------------

}
