package com.app.crud.spring_crud.service;

import com.app.crud.spring_crud.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public StudentDTO getStudent(Long id);
    public List<StudentDTO> getStudents();

    public StudentDTO createStudent(StudentDTO studentDTO);

    public StudentDTO deleteStudent(Long id);

    public StudentDTO updateStudent(StudentDTO studentDTO);
}
