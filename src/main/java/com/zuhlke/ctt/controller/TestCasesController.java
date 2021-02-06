package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class TestCasesController {
    private final TestCaseRepository testCaseRepository;

    @Autowired
    public TestCasesController(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @GetMapping("testcases/hello")
    @ResponseBody
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("Hellllloooooo");
    }

}
