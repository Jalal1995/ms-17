package com.example.ms17task.repository;


import com.example.ms17task.model.Account;
import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByName(String name);

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<Account> findById(long id);


}
