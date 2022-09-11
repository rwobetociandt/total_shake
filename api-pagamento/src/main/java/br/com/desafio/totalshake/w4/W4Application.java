package br.com.desafio.totalshake.w4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class W4Application {

	public static void main(String[] args) {
		SpringApplication.run(W4Application.class, args);
	}

}
