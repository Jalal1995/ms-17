package com.example.ms17task.controller;


import com.example.ms17task.service.TransferService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
@Slf4j
public class TransferController {

    private final TransferService transferService;


    @PostMapping("/amount/{amount}")
    public void doTransfer(@PathVariable BigDecimal amount) throws Exception {
        transferService.doTransferWithoutTransactional(amount);
    }


}
