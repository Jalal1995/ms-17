package com.example.ms17task.service;

import com.example.ms17task.dto.CompanyCriteriaDTO;
import com.example.ms17task.dto.CompanyDTO;
import java.util.List;

public interface CompanyService {

    CompanyDTO save(CompanyDTO student);

    CompanyDTO findById(long id);

    List<CompanyDTO> findAll(CompanyCriteriaDTO criteriaDTO);

    List<CompanyDTO> findAll();

}
