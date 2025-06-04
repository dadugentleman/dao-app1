package com.example.crud_app.dao;

import com.example.crud_app.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
