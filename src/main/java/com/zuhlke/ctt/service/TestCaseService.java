package com.zuhlke.ctt.service;

import com.zuhlke.ctt.model.dto.RunTestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TestCaseService {
    public ResponseEntity<RunTestDto> runSingleTestCase(Long id);
    public ResponseEntity<List<RunTestDto>> runTestSuite(Long id);
}
