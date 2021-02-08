package com.zuhlke.ctt.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "testSuite",cascade=CascadeType.ALL, orphanRemoval=true)
    private List<SummationTest> summationTests;



}
