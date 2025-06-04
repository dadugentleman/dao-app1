package com.example.crud_app;

import com.example.crud_app.dao.StudentDAO;
import com.example.crud_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
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
	private void readStudent(StudentDAO studentDAO) {
		// creeaza un obiect de tip Student
		System.out.println("Creating new student object...");
		Student newStudent = new Student("mircea", "Popescu", "mircea@gmail.com");

		// salveaza studentul in baza de date
		System.out.println("Saving the student");
		studentDAO.save(newStudent);

		// afiseaza id-ul studentului salvat
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// recupereaza studentul pe baza id-ului
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// afiseaza detaliile studentului
		System.out.println("Found the student: " + myStudent);
	}
	private void queryForStudents(StudentDAO studentDAO) {

		// obtine lista de studenti
		List<Student> theStudents = studentDAO.findAll();

		// afiseaza lista de studenti
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}

}
