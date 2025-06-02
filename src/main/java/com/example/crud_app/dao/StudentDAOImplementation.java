package com.example.crud_app.dao;

import com.example.crud_app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
