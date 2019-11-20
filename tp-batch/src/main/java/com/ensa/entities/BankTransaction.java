package com.ensa.entities;

import java.util.Date;

public class BankTransaction {
	private Long idTransaction;
	private long idCompte;
	private double montant;
	private Date dateTransaction;
	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	
	
    
}
