package com.fpm.fpm.service;

import com.fpm.fpm.model.Transactions;
import com.fpm.fpm.model.User;
import com.fpm.fpm.overviewDto.Overview;
import com.fpm.fpm.repository.TransactionsJpaRepository;
import com.fpm.fpm.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import  java.time.LocalDateTime;
import java.lang.*;
import java.sql.Date;
@Service
public class TransactionService implements TransactionsRepository {
    @Autowired
    private TransactionsJpaRepository transactionsJpaRepo;


    @Override
    public List<Transactions> getAllTransactions(String username){
        List<Transactions> t=transactionsJpaRepo.findByUsername(username);
        return t;
    }

    @Override
    public Transactions createTransactions(Transactions obj){
        LocalDateTime time=LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(time);
        obj.setTransactionDate(timestamp);
        obj.setUsername(obj.getUsername().toUpperCase());
        obj.setType(obj.getType().toUpperCase());
        return transactionsJpaRepo.save(obj);
    }

    @Override
    public Transactions updateTransactions(Transactions obj){
        try{
            Transactions objFromDb=transactionsJpaRepo.findById(obj.getId()).get();
            if(obj.getTransactionName()!= null){
                objFromDb.setTransactionName(obj.getTransactionName());
            }
            if(obj.getType()!= null){
                objFromDb.setType(obj.getType());
            }

            if(obj.getCategory()!= null){
                objFromDb.setCategory(obj.getCategory());
            }

            if(obj.getDebit()!= -1){
                objFromDb.setDebit(obj.getDebit());
            }
         if(obj.getCredit()!= -1){
                objFromDb.setCredit(obj.getCredit());
            }

            return  transactionsJpaRepo.save(objFromDb);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
        }

    }

    @Override
    public String deleteTransactions(UUID id){
        try{
            Transactions t=transactionsJpaRepo.findById(id).get();
            transactionsJpaRepo.deleteById(id);
            return "Transaction deleted successfully";
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"transaction already deleted");
        }
    }

    @Override
    public  Long getTotalCredits(String username){
        Long a= transactionsJpaRepo.getTotalCreditByUsername(username);
        return  a;
    }

    @Override
    public  Long geTotalDebits(String username){
        Long a= transactionsJpaRepo.getTotalDebitByUsername(username);
        return  a;
    }

    @Override
    public   List<Transactions> getThreeRecent(String username){
        List<Transactions> lt=transactionsJpaRepo.findLastThreeRowsByUsername(username);
        return  lt;
    }

    @Override
    public List<Overview> getOverview(String username) {
        List<Object[]> a = transactionsJpaRepo.findDailyTransactionSummary(username);
        List<Overview> o = new ArrayList<>();

        for (Object[] e : a) {
            Date d = (Date) e[0];
            Long deb = (Long) e[1];
            Long cre = (Long) e[2];
            Overview over = new Overview(d, deb, cre);
            o.add(over);
        }
        return o;
    }

   public List<Transactions> saveAllTrns(List<Transactions> t){
        return  transactionsJpaRepo.saveAll(t);
    }

}
