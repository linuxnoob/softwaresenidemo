package com.example.test.demo.SoftwareSeni.Controller;


import com.example.test.demo.SoftwareSeni.Entity.Transcation;
import com.example.test.demo.SoftwareSeni.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transcation> findAllTranscations() {
        return transactionService.getAllTRX();
    }

    @GetMapping("/transaction")
    public List<Transcation> findAllTranscationsById() {
        return transactionService.getAllTRX();
    }

}
