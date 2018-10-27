package com.xiaochen.demo.controller;

import com.xiaochen.demo.myAutoConfigure.FixStrService;
import com.xiaochen.demo.myAutoConfigure.MyConditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private MyConditionalService myConditionalService;
    @Autowired
    private FixStrService fixStrService;

    /**
     * visit url:http://localhost:8888/test/tips
     *
     * @return
     */
    @GetMapping("/tips")
    public Map tips() {
        Map map = new HashMap();
        map.put("tips", "hello");
        map.put("curTime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        return map;
    }

    /**
     * visit url:http://localhost:8888/test/myAutoConf
     *
     * @return
     */
    @RequestMapping("/myAutoConf")
    public String myAutoConf() {
        return myConditionalService.info();
    }

    /**
     * visit url:http://localhost:8888/test/input?word=xiaochen
     * @param word
     * @return
     */
    @GetMapping("/input")
    public String input(String word) {
        return fixStrService.wrap(word);
    }
}
