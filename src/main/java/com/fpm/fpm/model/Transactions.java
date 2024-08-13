package com.fpm.fpm.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

import java.util.*;

@Entity
@Table(name="transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;
    @Column(name="username")
    private String username;
    @Column(name="transactionname")
    private String transactionName ;
    @Column(name="category")
    private String category ;
    @Column(name="transactiondate")
    private Timestamp transactionDate ;
    @Column(name="debit")
    private int debit;
    @Column(name="credit")
    private int credit;
    @Column(name="type")
    private String type;
public Transactions(){}
    public Transactions(UUID id, String username, String transactionName, String category, Timestamp transactionDate, int debit,int credit, String type) {
        this.id = id;
        this.username = username;
        this.transactionName = transactionName;
        this.category = category;
        this.transactionDate = transactionDate;
        this.debit=debit;
        this.credit=credit;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
