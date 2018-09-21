package com.xiaochen.demo.myAutoConfigure;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditionalClz extends SpringBootCondition {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Map<String, Object> annotationMap = metadata.getAnnotationAttributes(MyConditionAnnotation.class.getName());
		logger.info("=========>> annotationMap:{}",annotationMap.toString());
		
		if (annotationMap == null || annotationMap.get("key") == null || annotationMap.get("val") == null) {
			return new ConditionOutcome(false, "condition configure param null");
		}
		// 获取environment中的值
		String keyVal = context.getEnvironment().getProperty(annotationMap.get("key").toString());
		if (annotationMap.get("val").equals(keyVal)) {
			// 如果environment中的值与指定的value一致，则返回true
			return new ConditionOutcome(true, "ok");
		}
		return new ConditionOutcome(false, "condition configure param no equal");
	}

}