package com.framework.ui;

import com.framework.configuration.EnvironmentConfiguration;
import com.framework.configuration.TestConfigurationUI;
import com.framework.data.Data;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

@ContextConfiguration(classes = TestConfigurationUI.class)
public abstract class AbstractTest extends AbstractTestNGSpringContextTests{

    @BeforeMethod(alwaysRun = true)
    public void openPage(){
        open(EnvironmentConfiguration.INSTANCE.getEnvironmentConfig().url());
    }

    public void setUpOptimizeCampaigns(){
        new Data().prepareData();
    }

}
