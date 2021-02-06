package com.zuhlke.ctt.service;

import com.zuhlke.ctt.model.dto.*;
import com.zuhlke.ctt.model.entities.TestCase;
import com.zuhlke.ctt.model.entities.TestSuite;
import com.zuhlke.ctt.repository.TestCaseRepository;
import com.zuhlke.ctt.repository.TestSuiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:25 PM
 */
@Service
public class SummationTestServiceImpl implements SummationTestService{

    private final TestCaseRepository testCaseRepository;
    private final TestSuiteRepository testSuiteRepository;

    public SummationTestServiceImpl(TestCaseRepository testCaseRepository, TestSuiteRepository testSuiteRepository) {
        this.testCaseRepository = testCaseRepository;
        this.testSuiteRepository = testSuiteRepository;
    }


    @Override
    public ResponseEntity<RunTestResponseDto> runSingleTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
        ////call cmw rest api and get Result
        //// compare actual result with expected result
        //// save result into entity
        return null;
    }

    @Override
    public ResponseEntity<List<RunTestResponseDto>> runTestSuite(Long id) {
        TestSuite testSuite = testSuiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
        List<RunTestResponseDto> result = new ArrayList<>();
        for (TestCase testCase : testSuite.getTestCases()){
            RunTestResponseDto runSingleTestResult = this.runSingleTestCase(testCase.getId()).getBody();
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
        List<TestCase> allTestCases = (List<TestCase>) testCaseRepository.findAll();
        List<TestCaseDto> testCaseDtos = allTestCases.stream().map(objA -> {
            return new TestCaseDto(objA);
        }).collect(Collectors.toList());

        return new ResponseEntity<>(testCaseDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TestCaseDto> getSingleTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return new ResponseEntity<>(new TestCaseDto(testCase), HttpStatus.OK);
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
