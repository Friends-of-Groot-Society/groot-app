package com.gl.restTemplateBuilderDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

/**
 * @author -ThomasMiltonMaestas
 */
public class MyRestTemplateCustomizer implements RestTemplateCustomizer {

    @Autowired
    private MyRequestInterceptor myRequestInterceptor;

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(myRequestInterceptor);
    }
}
