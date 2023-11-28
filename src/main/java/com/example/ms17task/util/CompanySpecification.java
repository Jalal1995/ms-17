package com.example.ms17task.util;

import com.example.ms17task.model.Company;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CompanySpecification {

    public Specification<Company> hasName(String name) {
        return (company, cq, cb) -> cb.equal(company.get("name"), name);
    }

    public Specification<Company> hasAddress(String address) {
        return (company, cq, cb) -> cb.equal(company.get("address"), address);
    }

    public Specification<Company> hasTin(String tin) {
        return (company, cq, cb) -> cb.equal(company.get("tin"), tin);
    }

    public static Specification<Company> hasMission(String mission) {
        return (company, cq, cb) -> cb.equal(company.get("mission"), mission);
    }






    /*
    public List<Book> findBooks(String title, String author, String genre) {
    return bookRepository.findAll(
            Specification.where(BookSpecification.hasTitle(title))
            .and(BookSpecification.hasAuthor(author))
            .and(BookSpecification.hasGenre(genre))
    );


     */
}