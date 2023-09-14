package com.example.librarymanagementsystemsept.repository;

import com.example.librarymanagementsystemsept.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
}
