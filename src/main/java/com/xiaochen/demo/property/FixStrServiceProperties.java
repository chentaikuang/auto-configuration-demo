package com.xiaochen.demo.property;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("fixStr.service")
public class FixStrServiceProperties {

    private String prefix = "DDDDDD";
    private String suffix = "FFFFFF";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
