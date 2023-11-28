package com.example.ms17task.service;

import com.example.ms17task.model.Account;
import java.math.BigDecimal;

public interface TransferService {

    void doTransfer(BigDecimal amount) throws Exception;

    void doTransferWithoutTransactional(BigDecimal amount) throws Exception;

    Account saveAccount(Account amount) throws Exception;

    public Account createAccount(Account account);

    Account saveAccountWihTransactional(Account amount);

}
