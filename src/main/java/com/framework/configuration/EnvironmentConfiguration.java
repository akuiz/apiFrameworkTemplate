package com.framework.configuration;

import org.aeonbits.owner.ConfigFactory;

public class EnvironmentConfiguration {
    public static final EnvironmentConfiguration INSTANCE = new EnvironmentConfiguration();
    private EnvironmentConfig environmentConfig;

    private EnvironmentConfiguration() {
        this.environmentConfig = ConfigFactory.create(EnvironmentConfig.class, System.getenv(), System.getProperties());
    }

    public EnvironmentConfig getEnvironmentConfig() {
        return environmentConfig;
    }
}
