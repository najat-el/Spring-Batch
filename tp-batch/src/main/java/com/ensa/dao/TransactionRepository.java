package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
