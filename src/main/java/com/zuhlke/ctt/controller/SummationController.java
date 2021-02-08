package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.*;
import com.zuhlke.ctt.service.TestCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public SummationController(@Qualifier("SummationTestService") TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }


    @RequestMapping(value = "testCases/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<RunTestDto> runSingleTestCase(@PathVariable Long id) throws Throwable {
        return testCaseService.runSingleTestCase(id);
    }
    @RequestMapping(value = "testSuites/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RunTestDto>> runTestSuite(@PathVariable Long id) throws Throwable {
        return testCaseService.runTestSuite(id);
    }

}

