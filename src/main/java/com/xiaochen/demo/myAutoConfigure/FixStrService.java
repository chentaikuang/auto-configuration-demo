package com.xiaochen.demo.myAutoConfigure;

public class FixStrService {

    private String prefix;
    private String suffix;

    public FixStrService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String wrap(String word) {
        return prefix + word + suffix;
    }
}
