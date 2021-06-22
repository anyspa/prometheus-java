package com.micro.prometheus_demo.controller;

import com.micro.prometheus_demo.service.DemoServiceImpl;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private DemoServiceImpl demoService;

    @Counted
    @Timed
    @GetMapping("/index")
    public String index(@RequestParam(name = "name") String name) throws InterruptedException {
        return demoService.sayHello(name);
    }

    @Counted
    @Timed
    @GetMapping("/core")
    public String core(@RequestParam(name = "name") String name) throws InterruptedException {
        return demoService.sayHello2(name);
    }
}
