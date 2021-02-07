package com.zuhlke.ctt.model.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class SummationTest extends TestCase{

    private int expectedResult;
    @ElementCollection
    private List<Integer> summands;


}


