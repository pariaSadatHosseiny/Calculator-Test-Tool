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
    public ResponseEntity<RunTestDto> runSingleTestCase(Long id);

    public ResponseEntity<List<RunTestDto>> runTestSuite(Long id);

    public ResponseEntity<List<TestCaseDto>> getAllTestCases();

    public ResponseEntity<List<TestSuiteDto>> getAllTestSuites();

    public ResponseEntity<TestCaseDto> getSingleTestCase(Long id);

    public ResponseEntity<TestSuiteDto> getSingleTestSuite(Long id);

    public ResponseEntity<TestCaseDto> createNewTestCase(CreateTestCaseDto testCase);

    public ResponseEntity<TestSuiteDto> createNewTestSuite(CreateTestSuiteDto testSuite);

    public ResponseEntity<TestCaseDto> patchUpdateTestCase(Long id, CreateTestCaseDto testCase);

    public ResponseEntity<TestSuiteDto> patchUpdateTestSuite(Long id, CreateTestSuiteDto testSuite);

    public ResponseEntity<TestCaseDto> putUpdateTestCase(Long id, CreateTestCaseDto testCase);

    public ResponseEntity<TestSuiteDto> putUpdateTestSuite(Long id, CreateTestSuiteDto testSuite);

    public ResponseEntity<TestCaseDto> deleteTestCase(Long id);

    public ResponseEntity<TestSuiteDto> deleteTestSuite(Long id);

    //TODO sample
   /* public ResponseEntity<Contact> createNewContact(Contact contact, HttpServletRequest request);
    public ResponseEntity<Contact> patchUpdateContact(Long id, Contact contactUpdates);
    public ResponseEntity<Contact> putUpdateContact(Long id, Contact contactUpdates);
    public ResponseEntity<Contact> deleteContact(Long id);*/

}
