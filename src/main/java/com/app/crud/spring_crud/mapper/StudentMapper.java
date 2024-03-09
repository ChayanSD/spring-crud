package com.app.crud.spring_crud.mapper;


import com.app.crud.spring_crud.dto.StudentDTO;
import com.app.crud.spring_crud.model.Student;

/*
Mapper class convert the dto to entity and entity to dto
Pro tips:
1.What's the return type make the instance first
set->get
*/
public class StudentMapper {
    //DTO to Entity
    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    //Entity to DTO
    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        return student;
    }

}
