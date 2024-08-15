package com.fpm.fpm.controller;
import com.fpm.fpm.model.Transactions;
import com.fpm.fpm.overviewDto.Overview;
import com.fpm.fpm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = "https://fpm-frontend.vercel.app/")
@RestController
public class TransactionsController {
    @Autowired
    public TransactionService transactionService;

    @GetMapping("/test")
    public String home(){
        return "Welcome to Financial Portfolio Management";
    }

    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions(@Param("username") String username){
        return transactionService.getAllTransactions(username);
    }

    @PostMapping("/transactions/addTransaction")
    public Transactions addNewTransactions(@RequestBody Transactions obj){
        return  transactionService.createTransactions(obj);
    }
    @PutMapping("/transactions/updateTransactions")
    public Transactions updateTransactions(@RequestBody Transactions obj){
        return  transactionService.updateTransactions(obj);
    }

    @DeleteMapping("/transactions/deleteTransactions/{id}")
    public String deleteTrans(@PathVariable("id") UUID id){
        return transactionService.deleteTransactions(id);
    }

    @GetMapping("/transactions/credits")
    public Long getTotals(@Param("username") String username){
        return  transactionService.getTotalCredits(username);
    }

    @GetMapping("/transactions/debits")
    public  Long getTotalDebit(@Param("username") String username){
        return  transactionService.geTotalDebits(username);
    }

    @GetMapping("/transactions/recent")
    public List<Transactions> getRecent(@Param("username") String username){
        return  transactionService.getThreeRecent(username);
    }

    @GetMapping("/transactions/overview")
    public List<Overview> getOverview(@Param("username") String username){
        return  transactionService.getOverview(username);
    }

    @PostMapping("/saveAll")
    public List<Transactions> saveA(@RequestBody List<Transactions> t){
        return  transactionService.saveAllTrns(t);
    }

}
