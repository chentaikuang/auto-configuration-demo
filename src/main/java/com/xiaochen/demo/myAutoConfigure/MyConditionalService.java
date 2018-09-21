package com.xiaochen.demo.myAutoConfigure;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MyConditionalService {
	private String key;
	private String val;

	public MyConditionalService(String key, String val) {
		if (StringUtils.isBlank(val))
			val = "NULL";
		this.key = key;
		this.val = val;
	}

	public String info() {
		Map<String, String> map = new HashMap<>();
		map.put(key, val);
		return map.toString();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
