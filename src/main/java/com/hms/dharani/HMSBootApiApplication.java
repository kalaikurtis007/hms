package com.hms.dharani;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "Dharani HMS API", version = "1.0", description = "HMS Information"))
public class HMSBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HMSBootApiApplication.class, args);
	}

	@Scheduled(cron ="0 5 * * * ?")
	public void scheduleFixedDelayTask() {
		System.out.println(
				"Fixed delay task - " + System.currentTimeMillis() / 1000);
	}
}
