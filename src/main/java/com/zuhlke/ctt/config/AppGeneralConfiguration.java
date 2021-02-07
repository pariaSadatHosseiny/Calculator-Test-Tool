package com.zuhlke.ctt.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by  paria
 * Date:       2/6/2021
 * Time:       9:25 PM
 */

@Configuration
public class AppGeneralConfiguration {
    //for application Configuration

    @Bean
    @Qualifier("generalRestTemplate")
    public RestTemplate restTemplateGeneral() {
        RestTemplate restTemplate = new RestTemplate(this.getClientHttpRequestFactory());
        return restTemplate;
    }

    /**
    * timeout config is set for Rest template
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }


}
