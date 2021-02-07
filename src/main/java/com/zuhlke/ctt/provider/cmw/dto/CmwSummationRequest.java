package com.zuhlke.ctt.provider.cmw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CmwSummationRequest {
    private List<Integer> summands;
}
