package com.framework.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("application.properties")
public class TestConfigurationUI {

    @Value("${browser}")
    public String browser;


    @PostConstruct
    public void setProperties() {
        com.codeborne.selenide.Configuration.browser = browser;
    }

}
