package com.zuhlke.ctt.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

@Entity
@Getter
@Setter
public class TestSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "testSuite",cascade=CascadeType.ALL, orphanRemoval=true)
    private List<SummationTest> summationTests;



}
