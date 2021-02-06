package com.zuhlke.ctt.model.dto;

import com.zuhlke.ctt.model.entities.TestSuite;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       10:47 PM
 */

@Setter
@Getter
@NoArgsConstructor
public class TestSuiteDto {

    private Long id;
    private String name;

    public TestSuiteDto(TestSuite testSuite) {
        this.id = testSuite.getId();
        this.name = testSuite.getName();
    }
}
