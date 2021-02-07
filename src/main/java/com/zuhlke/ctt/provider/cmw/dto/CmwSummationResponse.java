package com.zuhlke.ctt.provider.cmw.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

@Data
@NoArgsConstructor
public class CmwSummationResponse {

    private Integer[] summands;
    private Integer sum;

}
