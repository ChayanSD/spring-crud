package com.app.crud.spring_crud.dao;

import com.app.crud.spring_crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Long> {}
