package com.app.crud.spring_crud.controller;

import com.app.crud.spring_crud.dto.StudentDTO;
import com.app.crud.spring_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //Get student by id
    @GetMapping("students/{id}")
    public StudentDTO getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDto){
        return studentService.createStudent(studentDto);
    }

    @DeleteMapping("/students/{id}")
    public StudentDTO deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/students")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDto){
        return studentService.updateStudent(studentDto);
    }
}
