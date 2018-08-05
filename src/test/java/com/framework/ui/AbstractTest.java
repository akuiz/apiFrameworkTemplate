package com.framework.ui;

import com.framework.configuration.TestConfigurationUI;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = TestConfigurationUI.class)
public class AbstractTest extends AbstractTestNGSpringContextTests{
}
