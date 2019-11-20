package com.ensa;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.dao.TransactionRepository;
import com.ensa.entities.Transaction;
@Component
public class BankTransactionItemWriter implements ItemWriter<Transaction>{
	@Autowired
   private TransactionRepository transactionRepository;
	@Override
	public void write(List<? extends Transaction> items) throws Exception {
       transactionRepository.saveAll(items)	;	
	}

}
