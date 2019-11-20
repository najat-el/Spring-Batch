package com.ensa;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.dao.CompteRepository;
import com.ensa.entities.BankTransaction;
import com.ensa.entities.Compte;
import com.ensa.entities.Transaction;
@Component
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction, Transaction>{
	@Autowired
    CompteRepository compteRepository;
	Transaction transaction;
	@Override
	public Transaction process(BankTransaction item) throws Exception {
		
		transaction.setIdTransaction(item.getIdTransaction());
		long id=item.getIdCompte();
		transaction.setCompte(compteRepository.findByIdCompte(id));
		transaction.setMontant(item.getMontant());
		transaction.setDateTransaction(item.getDateTransaction());
		transaction.setDateDebit(new Date());
		//débiter les comptes
		Compte compte=compteRepository.findByIdCompte(id);
		compte.setSolde(compte.getSolde()-item.getMontant());
		return transaction;
	}

}
