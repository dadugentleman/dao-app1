package com.example.crud_app.dao;

import com.example.crud_app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    //Camp pentru EntiryManager va fi utilizat pentru interactiunea
    //cu baza de date
    private EntityManager entityManager;

    // Injectarea EntiryManager prin constructor (practica recomandata
    //pentru testabiliatetea si modulariattea
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementarea metodei save pentru a salvarea unui obiect
    //student in baza de date


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // creare querry
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // returnam query results
        return theQuery.getResultList();
    }
    @Override
    public List<Student> findByLastName(String theLastName) {

        // crearea query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // setarea parametrilor pentru query
        theQuery.setParameter("theData", theLastName);

        // returnearea rezultatelor query
        return theQuery.getResultList();
    }


    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

}
