package com.framework.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.api.client.PromotionsClient;
import com.framework.api.utils.FeignClient;
import com.framework.api.utils.FeignDecoder;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Configuration
@PropertySource("application.properties")
@ComponentScan(value = "com.framework.api.step")
public class TestConfigurationAPI {

    @Value("${dms.url}")
    String dmsURL;

    @Value("${price_engine.url}")
    String priceEngineURL;

    @Bean
    ObjectMapper provideMapper(){
        return new ObjectMapper().disable(FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Bean
    PromotionsClient providePromotionsClient(ObjectMapper mapper) {
        return Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger(PromotionsClient.class))
                .decoder(new FeignDecoder(mapper))
                .encoder(new JacksonEncoder(mapper))
                .client(new FeignClient())
                .target(PromotionsClient.class, dmsURL);
    }

}
