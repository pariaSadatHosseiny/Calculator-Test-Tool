package com.zuhlke.ctt.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.setErrorHandler(new ExceptionHandler());
        return restTemplate;
    }


}
