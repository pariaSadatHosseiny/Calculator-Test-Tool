package com.zuhlke.ctt.provider.cmw.client;

import com.zuhlke.ctt.exceptions.RestCustomException;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationRequest;
import com.zuhlke.ctt.provider.cmw.dto.CmwSummationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

@Service
public class CmwWebServicesImpl implements CmwWebServices{

    @Autowired
    @Qualifier("generalRestTemplate")
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CmwWebServicesImpl.class);

    public CmwWebServicesImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CmwSummationResponse summation(CmwSummationRequest request) throws RestCustomException {

        /*
        call rest web service of Calculator Middle Ware
         */
        HttpEntity<CmwSummationRequest> restRequest = new HttpEntity<>(request);
        try {
            ResponseEntity<CmwSummationResponse> response = restTemplate.exchange("url", HttpMethod.POST, restRequest, CmwSummationResponse.class);
            CmwSummationResponse responseBody = response.getBody();
            return null;
        }catch (HttpStatusCodeException ex){
            logger.error("Error response returned from  CMW rest WebServices : {}" , ex);
             throw new RestCustomException(ex.getStatusCode().toString(),ex.getResponseBodyAsString() , ex.getCause());
        }
        catch (Exception ex){
            logger.error("Error occurred on calling CMW rest WebServices : {}" , ex);
            throw new RestCustomException("-1",ex.getMessage(),ex.getCause());
        }
    }
}
