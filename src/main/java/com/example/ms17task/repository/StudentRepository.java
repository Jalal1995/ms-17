package com.example.ms17task.repository;

import com.example.ms17task.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends CrudRepository<Student, Long> {

    //1.
    List<Student> findAllByStatusTrue();

    Optional<Student> findByName(String name);

    Optional<Student> findByNameLike(String name);

    Optional<Student> findByNameAndSurname(String name, String surname);

    // Native query

    @Query(value = "select * from t_student", nativeQuery = true)
    List<Student> findAllstudents2();

    @Query(value = "select * from t_student  s where  s.name=?1", nativeQuery = true)
    Optional<Student> findByNameNative(@Param("studentName") String name);

    //3. JPQL

    @Query(value = "select  s from Student s")
    List<Student> findAllJPQL();

    @Query(value = "select s from Student  s where  s.name=:studentName")
    Optional<Student> findByNameJPQL(@Param("studentName") String name);
}
