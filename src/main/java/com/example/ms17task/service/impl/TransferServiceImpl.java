package com.example.ms17task.service.impl;

import com.example.ms17task.model.Account;
import com.example.ms17task.repository.AccountRepository;
import com.example.ms17task.service.TransferService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final EntityManagerFactory entityManagerFactory;
    //  private  final TransferServiceImpl _self;


    @Override
    @Transactional(noRollbackFor = Exception.class)
   // @SneakyThrows
    public void doTransfer(BigDecimal amount) throws InterruptedException {


        Optional<Account> source = accountRepository.findById(2L);

        Optional<Account> target = accountRepository.findById(1L);


        if (source.get().getBalance().compareTo(amount) >= 0) {  //

            source.get().setBalance(source.get().getBalance().subtract(amount));

            //  accountRepository.save(source.get());

            Thread.sleep(4000);

//            if (true) {
//                throw new Exception("Exception happened!");
//            }

            target.get().setBalance(target.get().getBalance().add(amount));


            if (target.get().getBalance().compareTo(amount) > 0) {

                log.info("if condition  inside");
                accountRepository.save(target.get()); //

                log.info("if condition  inside");


            }


        }


    }

    @Override
    @Transactional
    public void doTransferWithoutTransactional(BigDecimal amount) throws Exception {

/*
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();


        try {
            transaction.begin();

            Account target = em.find(Account.class, 1L);
            Account source = em.find(Account.class, 2L);


            if (source.getBalance().compareTo(amount) >= 0) {  //
                source.setBalance(source.getBalance().subtract(amount));
            }


            if (true) {
                throw new Exception("Exception happened!");
            }

            target.setBalance(target.getBalance().add(amount));

        } catch (RuntimeException re) {
            transaction.rollback();
            throw re;
        } finally {
            transaction.commit();
            em.close();
        }*/

        log.trace("Thread id is {}", Thread.currentThread().getId());

        Account source = accountRepository.findById(2L).get();

        if (amount.compareTo(source.getBalance())>0)
            throw new RuntimeException("Insufficient amount in the account, required : " + amount + " available: " + source.getBalance());


        log.trace("Thread id retrieved account 1 {} {} ", Thread.currentThread().getId(), source.getBalance());


        Thread.sleep(5000);

        Account target = accountRepository.findById(1L).get();

        log.trace("Thread id retrieved account 3 {} {} ", Thread.currentThread().getId(), target.getBalance());

        source.setBalance(source.getBalance().subtract(amount));
        target.setBalance(target.getBalance().add(amount) );

      /*  accountRepository.save(source);

        accountRepository.save(target);*/

        log.trace("Thread completed {}", Thread.currentThread().getId());

    }



    @Transactional(propagation = Propagation.REQUIRED)
    public Account createAccount(Account account) {
        return this.saveAccountWihTransactional(account);
    }


    @Override
    // @Transactional
    public Account saveAccount(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        entityManager.persist(account);
        et.commit();
        entityManager.close();
        return account;
    }


    @Override
    @Transactional
    public Account saveAccountWihTransactional(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(account);
        return account;
    }
}