package com.app.crud.spring_crud.service.impl;

import com.app.crud.spring_crud.dao.StudentDao;
import com.app.crud.spring_crud.dto.StudentDTO;
import com.app.crud.spring_crud.mapper.StudentMapper;
import com.app.crud.spring_crud.model.Student;
import com.app.crud.spring_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentDTO getStudent(Long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        StudentDTO studentDTO = null;
        if (optionalStudent.isEmpty()) {
            return studentDTO;
        }
        StudentDTO response = StudentMapper.toDTO(optionalStudent.get());
        return response;
    }
    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = studentDao.findAll();
        List<StudentDTO> responseStudent = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = StudentMapper.toDTO(student);
            responseStudent.add(studentDTO);
        }
        return responseStudent;
    }
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        Student dbstudent = studentDao.save(student);
        StudentDTO response = StudentMapper.toDTO(dbstudent);
        return response;
    }
    @Override
    public StudentDTO deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        StudentDTO studentDTO = null;
        if (optionalStudent.isEmpty()) {
            return studentDTO;
        }
        studentDao.deleteById(id);
        StudentDTO response = StudentMapper.toDTO(optionalStudent.get());
        return response;
    }
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        Student dbstudent = studentDao.save(student);
        StudentDTO response = StudentMapper.toDTO(dbstudent);
        return response;
    }
}
