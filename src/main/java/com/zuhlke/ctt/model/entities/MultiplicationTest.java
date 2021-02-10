package com.zuhlke.ctt.model.entities;

import com.zuhlke.ctt.model.enums.TestResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Hidden
public class MultiplicationTest extends TestCase<Integer, TestResult, TestSuite> {

    private Long expectedResult;
    @ElementCollection
    private List<Integer> summands;

}


