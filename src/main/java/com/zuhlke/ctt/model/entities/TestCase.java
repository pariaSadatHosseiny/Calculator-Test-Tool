package com.zuhlke.ctt.model.entities;
import com.zuhlke.ctt.model.enums.TestResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String restUrl;
    private int expectedResult;
    @ElementCollection
    private List<Integer> summands;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEST_SUITE_ID", referencedColumnName = "ID")
    private TestSuite testSuite;

    private String errorMessage;

    @Enumerated(EnumType.STRING)
    private TestResult lastTestResult;


}


