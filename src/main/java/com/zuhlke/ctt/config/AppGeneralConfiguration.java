package com.zuhlke.ctt.config;

import com.zuhlke.ctt.model.entities.SummationTest;
import com.zuhlke.ctt.model.entities.TestCase;
import com.zuhlke.ctt.model.entities.TestSuite;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/*
 * Created by  paria
 * Date:       2/6/2021
 * Time:       9:25 PM
 */

/**
 * this class is to reConfig predefined modules in spring boot
 * @author paria
 */
@Configuration
public class AppGeneralConfiguration implements RepositoryRestConfigurer {
    //for application Configuration

    @Bean
    @Qualifier("generalRestTemplate")
    public RestTemplate restTemplateGeneral() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(TestCase.class);
        config.exposeIdsFor(TestSuite.class);
        config.exposeIdsFor(SummationTest.class);
    }

    /**
     * sets timeout config for Rest template References
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }


}
