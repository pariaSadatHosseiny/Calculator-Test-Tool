package com.zuhlke.ctt.provider.cmw.client;

import com.zuhlke.ctt.exceptions.RestCustomException;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationRequest;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationResponse;

public interface CmwWebServices {
    public CmwSummationResponse summation(CmwSummationRequest request) throws RestCustomException;
}
