package com.xiaochen.demo.myAutoConfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MyConditionalService.class)
public class MyServiceAutoConfigure {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${test_auto_configuration:}")
	public String testAutoConfiguration;
	
	@ConditionalOnMissingBean(MyConditionalService.class)
	@Bean
	public MyConditionalService initMyConditionService() {
		logger.info(this.getClass().getName() + "已加载");
		logger.info(this.getClass().getName() + ",testAutoConfiguration:{}",testAutoConfiguration);
		return new MyConditionalService("testAutoConfiguration",testAutoConfiguration);
	}

//	@Bean
//	@MyConditionAnnotation(key="k1",val="v1")
//	public MyConditionalService initMyConditionService() {
//		logger.info(this.getClass().getName() + "已加载");
//		logger.info(this.getClass().getName() + ",testAutoConfiguration:{}",testAutoConfiguration);
//		return new MyConditionalService("testAutoConfiguration",testAutoConfiguration);
//	}
}
