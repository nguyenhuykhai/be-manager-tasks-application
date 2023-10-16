package com.example.ProTaskifyAPI;

import com.example.ProTaskifyAPI.Models.Class;
import com.example.ProTaskifyAPI.Models.Project;
import com.example.ProTaskifyAPI.Models.Student;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.ServiceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ProTaskifyApiApplication {
	private final StudentRepo studentRepo;
	private final StudentServiceImpl studentService;
	private final ProjectRepo projectRepo;
	private final LecturerRepo lecturerRepo;
	private final SemesterRepo semesterRepo;
	private final ClassRepo classRepo;
	private final ArrayList<Integer> classArray;
	public static void main(String[] args) {
		SpringApplication.run(ProTaskifyApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				classArray.add(1);
				List<Class> classes = new ArrayList<>();
				Class class1 = Class.builder()
						.class_name("12A8")
						.semesterID(semesterRepo.findById(1).orElse(null))
						.lecturerID(lecturerRepo.findById(1).orElse(null))
						.build();
				classes.add(class1);
				Class class2 = Class.builder()
						.class_name("9.12")
						.semesterID(semesterRepo.findById(1).orElse(null))
						.lecturerID(lecturerRepo.findById(1).orElse(null))
						.build();
				classes.add(class2);
				classRepo.saveAll(classes);

				List<Student> students = new ArrayList<>();
				Student student1 = Student.builder()
						.score(3.2f)
						.about("")
						.link_facebook("https://www.facebook.com/hau.chu.334/")
						.github("https://github.com/RankillerDY")
						.email("abc@gmail.com")
						.classID(classRepo.findById(1).orElse(null))
						.is_leader(false)
//						.pending(studentService.writeArrayToByteArray(classArray))
						.build();
				students.add(student1);

				Student student2 = Student.builder()
						.score(3.2f)
						.about("")
						.link_facebook("https://www.facebook.com/hau.chu.334/")
						.github("https://github.com/RankillerDY")
						.email("abc@gmail.com")
						.classID(classRepo.findById(2).orElse(null))
						.is_leader(true)
						.build();
				students.add(student2);
				studentRepo.saveAll(students);

				List<Project> projects = new ArrayList<>();
				Project project1 = Project.builder()
						.project_name("Manhattan")
						.lecturerID(lecturerRepo.findById(1).orElse(null))
						.status(true)
						.problems("no problem")
						.context("The atomic boom")
						.functional_requirements("The explosion need to be 250ft tall")
						.non_functional_requirements("Destroy everything")
						.build();
				projects.add(project1);
				Project project2 = Project.builder()
						.project_name("Taskify")
						.lecturerID(lecturerRepo.findById(1).orElse(null))
						.status(true)
						.problems("no problem")
						.context("Help manage task")
						.functional_requirements("Able to settle things")
						.non_functional_requirements("high performance")
						.build();
				projects.add(project2);
				projectRepo.saveAll(projects);
			}
		};
	}
}
