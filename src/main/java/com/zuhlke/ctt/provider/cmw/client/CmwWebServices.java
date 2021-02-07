package com.zuhlke.ctt.provider.cmw.client;

import com.zuhlke.ctt.exceptions.RestCustomException;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationRequest;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationResponse;

/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

public interface CmwWebServices {
    public CmwSummationResponse summation(CmwSummationRequest request) throws RestCustomException;
}
