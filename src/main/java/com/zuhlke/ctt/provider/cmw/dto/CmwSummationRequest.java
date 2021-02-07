package com.zuhlke.ctt.provider.cmw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CmwSummationRequest {
    private List<Integer> summands;
}
