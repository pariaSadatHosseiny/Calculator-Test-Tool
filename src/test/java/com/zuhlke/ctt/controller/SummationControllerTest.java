package com.zuhlke.ctt.controller;

import com.zuhlke.ctt.model.dto.RunTestDto;
import com.zuhlke.ctt.model.enums.TestResult;
import com.zuhlke.ctt.service.SummationTestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by  paria
 * Date:       2/10/2021
 * Time:       10:27 AM
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = SummationController.class)
public class SummationControllerTest {

    public SummationControllerTest() {
    }

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    @Qualifier("SummationTestService")
    private SummationTestServiceImpl summationTestService;

    RunTestDto runTestDto = new RunTestDto((long) 1, "mockTest", TestResult.SUCCESS, "test successfully done :)");
    ResponseEntity<RunTestDto> mockRunTestDto =new  ResponseEntity<>(runTestDto,HttpStatus.OK);

    @Test
    public void runSingleTestCase() throws Exception {
        Mockito.when(summationTestService.runSingleTestCase(Mockito.any())).thenReturn(mockRunTestDto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/summation/testCases/10/run").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{\"testID\":1,\"testName\":\"mockTest\",\"testResult\":\"SUCCESS\",\"message\":\"test successfully done :)\"}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}