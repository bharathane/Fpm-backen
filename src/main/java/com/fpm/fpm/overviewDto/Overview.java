package com.fpm.fpm.overviewDto;



import java.time.LocalDate;
import java.sql.Date;

public class Overview {
    private Date transactionDate;
    private long totalDebits;
    private long totalCredits;

    public Overview(Date  transactionDate, long totalDebits, long totalCredits) {
        this.transactionDate = transactionDate;
        this.totalDebits = totalDebits;
        this.totalCredits = totalCredits;
    }

    // Getters and setters
    public Date   getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date   transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getTotalDebits() {
        return totalDebits;
    }

    public void setTotalDebits(long totalDebits) {
        this.totalDebits = totalDebits;
    }

    public long getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(long totalCredits) {
        this.totalCredits = totalCredits;
    }
}
