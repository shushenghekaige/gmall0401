package com.atguigu.gmall.manager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages="com.atguigu.gmall.manager.Mapper")
public class GmallManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallManagerServiceApplication.class, args);
	}

}
