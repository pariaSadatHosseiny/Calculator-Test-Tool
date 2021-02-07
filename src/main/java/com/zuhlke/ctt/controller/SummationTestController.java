package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.RunTestResponseDto;
import com.zuhlke.ctt.repository.TestCaseRepository;
import com.zuhlke.ctt.repository.TestSuiteRepository;
import com.zuhlke.ctt.service.SummationTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * how ever in spring data Rest documents is mentioned that we use #RepositoryRestController#
 * to replace a SDR rest method Impl but to stick to Pure SDR I wrote this Controller as you see bellow
 * Note : as I searched We can use Spring MVC with SDR when we have to implement some logic in our rest API method
 */
@RepositoryRestController
public class SummationTestController {
    /**
     * These dependencies are not used yet but they are useful when we want to custom one of the SDR Api CRUD methods
     */
    private final TestCaseRepository testCaseRepository;
    private final TestSuiteRepository testSuiteRepository;
    private final SummationTestService summationTestService;

    @Autowired
    public SummationTestController(TestCaseRepository testCaseRepository, TestSuiteRepository testSuiteRepository, SummationTestService summationTestService) {
        this.testCaseRepository = testCaseRepository;
        this.testSuiteRepository = testSuiteRepository;
        this.summationTestService = summationTestService;
    }

    @RequestMapping(value = "testcases/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<RunTestResponseDto> runSingleTestCase(@PathVariable Long id) throws Throwable {
        return summationTestService.runSingleTestCase(id);
    }
    @RequestMapping(value = "testsuites/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RunTestResponseDto>> runTestSuite(@PathVariable Long id) throws Throwable {
        return summationTestService.runTestSuite(id);
    }

    @GetMapping("testcases/test")
    @ResponseBody
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("Hellllloooooo sample for test case");
    }
    @GetMapping("testsuites/hello")
    @ResponseBody
    public ResponseEntity<?> hello2(){
        return ResponseEntity.ok("Hellllloooooo sample for test suite");
    }

}
