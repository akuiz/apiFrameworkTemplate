package com.framework.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan(value = "com.framework.api.step")
public class TestConfigurationAPI {

    @Value("${dms.url}")
    String dmsURL;

    @Value("${price_engine.url}")
    String priceEngineURL;

}
