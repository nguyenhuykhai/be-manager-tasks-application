package com.example.ProTaskifyAPI;

import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class ProTaskifyApiApplication {
	private final StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProTaskifyApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Student student = Student.builder()
						.score(3.2f)
						.student_id("SU1")
						.about("")
						.link_facebook("https://www.facebook.com/hau.chu.334/")
						.github("https://github.com/RankillerDY")
						.email("abc@gmail.com")
						.build();
				studentRepo.save(student);
			}
		};
	}
}
