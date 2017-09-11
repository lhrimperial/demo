package com;

import com.handy.demo.sboot.web.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootWebApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean myServlet(){
		return new ServletRegistrationBean(new MyServlet(), "/ws/*");
	}
}
