package com.framework.ui;

import com.framework.configuration.TestConfigurationUI;
import com.framework.data.Optimize;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

@ContextConfiguration(classes = TestConfigurationUI.class)
public abstract class AbstractTest extends AbstractTestNGSpringContextTests{

    @BeforeMethod
    public void openPage(){
        open("");
    }

    public void setUpOptimizeCampaigns(){
        new Optimize().prepareOptimizeCampaigns();
    }

}
