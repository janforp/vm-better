package com.janita.vm.vmbetter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VmBetterApplication implements CommandLineRunner {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(VmBetterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// try {
		// 	Runtime.getRuntime().exec("http://localhost:" + port + "/swagger-ui.html");
		// } catch (Exception ex) {
		// 	ex.printStackTrace();
		// }
	}
}
