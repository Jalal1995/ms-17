package com.example.ms17task.service;

import com.example.ms17task.dto.StudentDTO;
import com.example.ms17task.model.Student;
import java.util.List;

public interface StudentService {

    StudentDTO save(StudentDTO student);

    StudentDTO findById(long id);

    List<Student> findAll();

    String deleteById(long id);

    Student deleteByEntity(Student student);

    Student edit(long id, Student student);
}
