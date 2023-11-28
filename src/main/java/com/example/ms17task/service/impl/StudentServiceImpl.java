package com.example.ms17task.service.impl;

import com.example.ms17task.dto.StudentDTO;
import com.example.ms17task.exception.StudentNotFoundException;
import com.example.ms17task.model.Student;
import com.example.ms17task.repository.StudentRepository;
import com.example.ms17task.service.StudentService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentDTO save(StudentDTO studentDto) {

        TypeMap<StudentDTO, Student> propertyMapper = modelMapper.createTypeMap(StudentDTO.class, Student.class);
        propertyMapper.addMapping(StudentDTO::getStudentName, Student::setName);


        return modelMapper.map(studentRepository.save(modelMapper.map(studentDto, Student.class)), StudentDTO.class);
    }


    @Override
    public StudentDTO findById(long id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public String deleteById(long id) {

        Optional<Student> ifExits = studentRepository.findById(id);
        ifExits.ifPresent(studentRepository::delete);

        studentRepository.deleteById(id);

        return "success";
    }

    @Override
    public Student deleteByEntity(Student student) {
        return null;
    }

    @Override
    public Student edit(long id, Student student) {
        Optional<Student> ifExits = studentRepository.findById(id);
        if (ifExits.isPresent()) {
            ifExits.get().setName(student.getName());
            studentRepository.save(ifExits.get());
            //   studentRepository.save(student);
        }
        return ifExits.get();
    }


    private Student getMock() {
        return Student.
                builder()
                .id(1L)
                .name("Rauf")
                .surname("Bayramov")
                .build();
    }
}
