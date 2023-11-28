package com.example.ms17task.exception;

public class StudentNotFoundException extends NotFoundException {
    public static final String MESSAGE = "Student with id = %s does not found!";
    private static final long serialVersionUID = 5843213248811L;

    public StudentNotFoundException(Long studentId) {
        super(String.format(MESSAGE, studentId));
    }

}
