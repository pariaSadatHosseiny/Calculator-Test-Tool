package com.zuhlke.ctt.service;

import com.zuhlke.ctt.model.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

/*
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:14 PM
 */
public interface SummationTestService {
    /**
     * @param id
     * @return
     */
    public ResponseEntity<RunTestResponseDto> runSingleTestCase(Long id);

    public ResponseEntity<List<RunTestResponseDto>> runTestSuite(Long id);

    public ResponseEntity<List<TestCaseDto>> getAllTestCases();

    public ResponseEntity<List<TestSuiteDto>> getAllTestSuites();

    public ResponseEntity<TestCaseDto> getSingleTestCase(Long id);

    public ResponseEntity<TestSuiteDto> getSingleTestSuite(Long id);

    public ResponseEntity<TestCaseDto> createNewTestCase(CreateTestCaseRequestDto testCase);

    public ResponseEntity<TestSuiteDto> createNewTestSuite(CreateTestSuiteRequestDto testSuite);

    public ResponseEntity<TestCaseDto> patchUpdateTestCase(Long id, CreateTestCaseRequestDto testCase);

    public ResponseEntity<TestSuiteDto> patchUpdateTestSuite(Long id, CreateTestSuiteRequestDto testSuite);

    public ResponseEntity<TestCaseDto> putUpdateTestCase(Long id, CreateTestCaseRequestDto testCase);

    public ResponseEntity<TestSuiteDto> putUpdateTestSuite(Long id, CreateTestSuiteRequestDto testSuite);

    public ResponseEntity<TestCaseDto> deleteTestCase(Long id);

    public ResponseEntity<TestSuiteDto> deleteTestSuite(Long id);

    //TODO sample
   /* public ResponseEntity<Contact> createNewContact(Contact contact, HttpServletRequest request);
    public ResponseEntity<Contact> patchUpdateContact(Long id, Contact contactUpdates);
    public ResponseEntity<Contact> putUpdateContact(Long id, Contact contactUpdates);
    public ResponseEntity<Contact> deleteContact(Long id);*/

}
