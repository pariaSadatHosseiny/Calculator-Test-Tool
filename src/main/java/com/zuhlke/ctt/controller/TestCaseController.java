package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.RunTestDto;
import com.zuhlke.ctt.service.TestCaseService;
import org.springframework.beans.factory.BeanFactory;
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

    private static final String SERVICE_NAME_SUFFIX = "regionService";
    private final BeanFactory beanFactory;
    private final TestCaseService testCaseService;

    public TestCaseController(BeanFactory beanFactory, TestCaseService testCaseService) {
        this.beanFactory = beanFactory;
        this.testCaseService = testCaseService;
    }


    @RequestMapping(value = "testcases/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<RunTestDto> runSingleTestCase(@PathVariable Long id) throws Throwable {
        return testCaseService.runSingleTestCase(id);
    }
    @RequestMapping(value = "testsuites/run/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RunTestDto>> runTestSuite(@PathVariable Long id) throws Throwable {
        return testCaseService.runTestSuite(id);
    }

}
