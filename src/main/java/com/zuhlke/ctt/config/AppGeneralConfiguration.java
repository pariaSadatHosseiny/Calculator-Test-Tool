package com.zuhlke.ctt.config;

import com.zuhlke.ctt.model.entities.SummationTest;
import com.zuhlke.ctt.model.entities.MultiplicationTest;
import com.zuhlke.ctt.model.entities.TestCase;
import com.zuhlke.ctt.model.entities.TestSuite;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.client.RestTemplate;

/*
 * Created by  paria
 * Date:       2/6/2021
 * Time:       9:25 PM
 */

/**
 * this class is to reConfig predefined modules in spring boot
 *
 * @author paria
 */
@Configuration
public class AppGeneralConfiguration implements RepositoryRestConfigurer {

    /**
     * here in this Bean a reference of restTemplate is creating and you can use it
     * based on autowiring by name and using @Qualifier annotations
     * it is possible to use rest template builder to create a rest template reference with
     * custom Error handling as you want
     *
     * @return RestTemplate instance
     */
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
        config.exposeIdsFor(MultiplicationTest.class);
    }


}
