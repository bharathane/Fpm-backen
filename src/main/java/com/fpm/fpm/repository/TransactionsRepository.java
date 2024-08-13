package com.fpm.fpm.repository;
import com.fpm.fpm.model.Transactions;
import com.fpm.fpm.model.User;
import com.fpm.fpm.overviewDto.Overview;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.*;
public interface TransactionsRepository {
    List<Transactions> getAllTransactions(String username);
    Transactions createTransactions(Transactions obj);
    Transactions updateTransactions(Transactions obj);
    String deleteTransactions(UUID id);

    Long getTotalCredits(String username);

    Long geTotalDebits(String username);

    List<Transactions> getThreeRecent(String username);

    List<Overview> getOverview(String username);


}
