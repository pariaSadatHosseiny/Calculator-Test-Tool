package com.zuhlke.ctt.service;

import com.zuhlke.ctt.model.entities.SummationTest;
import com.zuhlke.ctt.provider.cmw.client.CmwWebServices;
import com.zuhlke.ctt.repository.SummationTestRepository;
import com.zuhlke.ctt.repository.TestSuiteRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by  paria
 * Date:       2/10/2021
 * Time:       2:18 PM
 */
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class SummationTestServiceImplTest {
    @Autowired
    @Mock
    private SummationTestRepository summationTestRepository;
    @Mock
    private  TestSuiteRepository testSuiteRepository;
    @Mock
    private  CmwWebServices cmwWebServices;

    @InjectMocks
    @Autowired
    @Qualifier("SummationTestService")
    private SummationTestServiceImpl summationTestService;

    @Test
    public void shouldThrowResponseStatusExceptionWhenTestCaseNotExists(){
        assertThrows(ResponseStatusException.class,() ->{
            summationTestService.runSingleTestCase(1L);
        });
    }
    @Test
    public void shouldNotThrowResponseStatusExceptionWhenTestCaseExists(){

        SummationTest summationTest = new SummationTest();
        summationTest.setExpectedResult(10);
        summationTest.setSummands(Arrays.asList(1,2,7));
        summationTest.setName("unit test");

        SummationTest test = summationTestRepository.save(summationTest);
        assertDoesNotThrow(() -> summationTestService.runSingleTestCase(1L ) );
    }
}