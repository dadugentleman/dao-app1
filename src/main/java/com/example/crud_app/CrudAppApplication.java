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

	private void createMultipleStudents(StudentDAO studentDAO) {
		//creeam mai multi studenti
		System.out.println("Creating 3 student objects");
		Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@gmail.com");
		Student newStudent2 = new Student("Iulian", "Vatamanu", "iulic@gmail.com");
		Student newStudent3 = new Student("Maria", "Mirabel", "maria@gmail.com");

		//salvam obiectele student in baza de date
		System.out.println("Saving the students");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
	}

}
