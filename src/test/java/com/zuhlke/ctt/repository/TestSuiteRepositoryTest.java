package com.zuhlke.ctt.repository;

import com.zuhlke.ctt.model.entities.TestSuite;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by  paria
 * Date:       2/8/2021
 * Time:       11:23 PM
 */

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
class TestSuiteRepositoryTest {

    @Autowired
    TestSuiteRepository testSuiteRepository;

    @Test
    public void saveTest() throws Exception {
        TestSuite testSuite = new TestSuite();
        testSuite.setName("paria Test");

        TestSuite t = testSuiteRepository.save(testSuite);
        List<?> queryResult = Collections.singletonList(testSuiteRepository.findById(t.getId()));

        assertFalse(queryResult.isEmpty());
        assertNotNull(queryResult.get(0));
    }

}