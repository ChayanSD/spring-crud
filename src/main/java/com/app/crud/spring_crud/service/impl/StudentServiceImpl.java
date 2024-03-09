package com.app.crud.spring_crud.service.impl;

import com.app.crud.spring_crud.dao.StudentDao;
import com.app.crud.spring_crud.dto.StudentDTO;
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
         studentDTO = new StudentDTO();
        studentDTO.setId(optionalStudent.get().getId());
        studentDTO.setName(optionalStudent.get().getName());
        studentDTO.setEmail(optionalStudent.get().getEmail());

        return studentDTO;
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = studentDao.findAll();
        List<StudentDTO> responseStudent = new ArrayList<>();

        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setEmail(student.getEmail());

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

        //Let's create the response
        StudentDTO response = new StudentDTO();
        response.setId(dbstudent.getId());
        response.setName(dbstudent.getName());
        response.setEmail(dbstudent.getEmail());

        return response;
    }

    @Override
    public StudentDTO deleteStudent(Long id) {
        //first fetching the student with id
        Optional<Student> optionalStudent = studentDao.findById(id);
        StudentDTO studentDTO = null;

        //if student not found with corresponding id then return null
        if (optionalStudent.isEmpty()) {
            return studentDTO;
        }
        //if found delete the record from database
        studentDao.deleteById(id);

        //response
        studentDTO = new StudentDTO();
        studentDTO.setId(optionalStudent.get().getId());
        studentDTO.setName(optionalStudent.get().getName());
        studentDTO.setEmail(optionalStudent.get().getEmail());

        return studentDTO;
    }
}
