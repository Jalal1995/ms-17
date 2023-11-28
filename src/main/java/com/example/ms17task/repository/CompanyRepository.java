package com.example.ms17task.repository;

import com.example.ms17task.model.Company;
import com.example.ms17task.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CompanyRepository extends CrudRepository<Company, Long>, JpaSpecificationExecutor<Company> {


    List<Company> findAll();
}
