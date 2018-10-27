package com.xiaochen.demo.myAutoConfigure;

import com.xiaochen.demo.property.FixStrServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(FixStrService.class)
@EnableConfigurationProperties(value = FixStrServiceProperties.class)
public class FixStrServiceAutoConfigure {

    @Autowired
    private FixStrServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "fixStr.service", value = "enabled", havingValue = "true")
    FixStrService fixStrService() {
        return new FixStrService(properties.getPrefix(), properties.getSuffix());
    }
}
