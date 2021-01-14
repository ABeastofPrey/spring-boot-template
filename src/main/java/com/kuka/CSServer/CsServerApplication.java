package com.kuka.CSServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.kuka.CSServer.mapper") //使用MapperScan批量扫描所有的Mapper接口；
public class CsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsServerApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Hello world!";
	}
}
