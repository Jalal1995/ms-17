package com.example.ms17task.controller;


import com.example.ms17task.dto.StudentDTO;
import com.example.ms17task.model.Student;
import com.example.ms17task.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public StudentDTO save(@RequestBody StudentDTO student) {
        return studentService.save(student);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/delete")
    public String deleteById(@Param("id") long id) {
        return studentService.deleteById(id);
    }

    @PutMapping("/edit/id/{id}")
    public Student edit(@RequestBody Student student, @PathVariable long id) {
        return studentService.edit(id, student);
    }

}
