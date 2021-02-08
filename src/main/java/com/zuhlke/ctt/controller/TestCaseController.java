package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.RunTestResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/api/v1/test/"}, produces = APPLICATION_JSON_VALUE)
public class TestCaseController {

   /* @RequestMapping(value = "testCases/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<RunTestResponseDto> runSingleTestCase(@PathVariable Long id) throws Throwable {
        return summationTestService.runSingleTestCase(id);
    }
    @RequestMapping(value = "testSuites/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RunTestResponseDto>> runTestSuite(@PathVariable Long id) throws Throwable {
        return summationTestService.runTestSuite(id);
    }*/

}
