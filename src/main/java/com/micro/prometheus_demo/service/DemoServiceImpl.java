package com.micro.prometheus_demo.service;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoServiceImpl {

	public String sayHello(String name) throws InterruptedException {
		log.info("{} call /demo/index sayHell method...", name);

		long milliSeconds = (long) (Math.random() * 2000);
		// 模拟请求异常情况
		if (milliSeconds > 1995) {
			log.error("call /demo/index sleep timeout");
			throw new RuntimeException("call /demo/index sleep timeout");
		}

		// 业务代码
		TimeUnit.MILLISECONDS.sleep(milliSeconds);

		return "Hello " + name;
	}


	public String sayHello2(String name) throws InterruptedException {
		log.info("{} call /demo/core sayHell2 method...", name);

		long milliSeconds = (long) (Math.random() * 3000);
		if (milliSeconds > 2995) {
			log.error("call /demo/core sleep timeout");
			throw new RuntimeException("call /demo/core sleep timeout");
		}

		TimeUnit.MILLISECONDS.sleep(milliSeconds);

		return "Hello " + name;
	}
}