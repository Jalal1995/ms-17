package com.example.ms17task.service.impl;

import com.example.ms17task.dto.CompanyCriteriaDTO;
import com.example.ms17task.dto.CompanyDTO;
import com.example.ms17task.model.Company;
import com.example.ms17task.repository.CompanyRepository;
import com.example.ms17task.service.CompanyService;
import com.example.ms17task.util.CompanySpecification;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {


    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    private final CompanySpecification companySpecification;


    @Override


    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = companyRepository.save(modelMapper.map(companyDTO, Company.class));
        return modelMapper.map(company, CompanyDTO.class);
    }

    @Override
    public CompanyDTO findById(long id) {
        return modelMapper.map(companyRepository.findById(id).get(), CompanyDTO.class);
    }

    @Override
    public List<CompanyDTO> findAll(CompanyCriteriaDTO criteriaDTO) {

        return companyRepository
                .findAll(Specification
                        .where(companySpecification.hasName(criteriaDTO.getName()))
                        .and(companySpecification.hasAddress(criteriaDTO.getAddress()))
                        .or(companySpecification.hasMission(criteriaDTO.getMission()))


                ).stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());


    }

    @Override
    @Transactional
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }
}
