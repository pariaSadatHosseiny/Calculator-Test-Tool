package com.zuhlke.ctt.model.entities;/*
 * Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

import com.zuhlke.ctt.model.enums.TestResult;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;

import javax.persistence.*;

/**
 * it represents a testCase Entity which is super class for all types
 * of test cases. for this prototype we have only summationTestCase but
 * maybe in future we would have a subtractionTestCase and then we can
 * have the same entity fields in this super class entity
 * it is using singleTable type as Inheritance strategy
 * @author paria
 */

@MappedSuperclass
@Data
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Test_type")
public class TestCase<T1,T2,T3> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T1 id;
    private String name;
    private String errorMessage;
    @Enumerated(EnumType.STRING)
    private T2 lastTestResult;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEST_SUITE_ID", referencedColumnName = "ID")
    private T3 testSuite;

    //TODO where to save the rest urls of cmw rest api for each testcase? here or in config file
    //private String restUrl;
}
