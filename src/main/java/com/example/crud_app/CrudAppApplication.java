package com.example.crud_app;

import com.example.crud_app.dao.StudentDAO;
import com.example.crud_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		//cream un obiect Student
		System.out.println("Creating student");
		Student newStudent = new Student("John", "Doe", "john@gmail.com");

		//Salvam obiectul Student in baza de date folosind DAO
		System.out.println("Saving the student");
		studentDAO.save(newStudent);

		// afisam ID-ul student salvat
		System.out.println("Saved student. Generated id: " + newStudent.getId());


	}

}
