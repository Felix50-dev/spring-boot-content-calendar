package com.root.content_calendar;

import com.root.content_calendar.config.ContentCalendarProperties;
import com.root.content_calendar.model.Content;
import com.root.content_calendar.model.Status;
import com.root.content_calendar.model.Type;
import com.root.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			Content c = new Content(
					null, "Euro Final Prediction.",
					"Predicted euro winner.",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					""
			);
			repository.save(c);
		};
	}
}
