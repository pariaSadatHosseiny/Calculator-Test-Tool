package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.RunTestDto;
import com.zuhlke.ctt.repository.SummationTestRepository;
import com.zuhlke.ctt.repository.TestSuiteRepository;
import com.zuhlke.ctt.service.SummationTestService;
import com.zuhlke.ctt.service.TestCaseService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * how ever in spring data Rest documents is mentioned that we use #RepositoryRestController#
 * to replace a SDR rest method Impl but to stick to Pure SDR I wrote this Controller as you see bellow
 * Note : as I searched We can use Spring MVC with SDR when we have to implement some logic in our rest API method
 *
 * attention : unfortunately springFox support is missing @RepositoryRestController if you want to add this controller
 * to swagger ui you can use both @RepositoryRestController and @RestController
 */
@RepositoryRestController
public class MultiplicationController {
    /**
     * These dependencies are not used yet but they are useful when we want to custom one of the SDR Api CRUD methods
     */

    private final TestCaseService testCaseService;
    private final SummationTestRepository summationTestRepository;
    private final TestSuiteRepository testSuiteRepository;
    private final SummationTestService summationTestService;

    @Autowired
    public MultiplicationController(@Qualifier("MultiplicationTestService") TestCaseService testCaseService, SummationTestRepository summationTestRepository, TestSuiteRepository testSuiteRepository, SummationTestService summationTestService) {
        this.testCaseService = testCaseService;
        this.summationTestRepository = summationTestRepository;
        this.testSuiteRepository = testSuiteRepository;
        this.summationTestService = summationTestService;
    }

    @RequestMapping(value = "testcases/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<RunTestDto> runSingleTestCase(@PathVariable Long id) throws Throwable {
        return testCaseService.runSingleTestCase(id);
    }
    @RequestMapping(value = "testsuites/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RunTestDto>> runTestSuite(@PathVariable Long id) throws Throwable {
        return testCaseService.runTestSuite(id);
    }

    @GetMapping("testCases/test")
    @ResponseBody
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("it is a test");
    }
    @GetMapping("testSuites/hello")
    @ResponseBody
    public ResponseEntity<?> hello2(){
        return ResponseEntity.ok("it is a test");
    }

}
