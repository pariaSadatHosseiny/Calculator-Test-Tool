package com.zuhlke.ctt.provider.cmw.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CmwSummationResponse {

    private Integer[] summands;
    private Integer sum;

}
