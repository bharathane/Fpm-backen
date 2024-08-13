package com.fpm.fpm.repository;

import com.fpm.fpm.model.Transactions;
import  com.fpm.fpm.overviewDto.Overview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.fpm.fpm.overviewDto.*;

import java.util.*;
public interface TransactionsJpaRepository extends JpaRepository<Transactions,UUID> {

    List<Transactions> findByUsername(String username);
    @Query("select SUM(credit) from Transactions where username= :username")
    Long getTotalCreditByUsername( String username);

    @Query("select SUM(debit) from Transactions where username= :username")
    Long getTotalDebitByUsername( String username);

    @Query(value = "SELECT * FROM Transactions where username= :username ORDER BY transactionDate DESC LIMIT 3", nativeQuery = true)
    List<Transactions> findLastThreeRowsByUsername(String username);

    @Query(value = "SELECT CAST(t.transactionDate AS date), SUM(t.debit), SUM(t.credit) " +
            "FROM Transactions t " +
            "where username = :username "+

            "GROUP BY CAST(t.transactionDate AS date) "+
            "ORDER BY CAST(transactionDate AS date) DESC " +
            "LIMIT 7",nativeQuery = true)

    List<Object[]> findDailyTransactionSummary(String username);

}
