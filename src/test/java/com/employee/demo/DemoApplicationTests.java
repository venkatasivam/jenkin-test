package com.employee.demo;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	
	public static Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
	
	@Test
	void contextLoads() {
		log.info("**** TEST CASE RUNNING *****");
	}

}
