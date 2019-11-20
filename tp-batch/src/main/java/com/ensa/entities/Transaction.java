package com.ensa.entities;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Transaction {
	@Id
	private Long idTransaction;
	private Compte Compte;
	private double montant;
	private Date dateTransaction;
	private Date dateDebit;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(Long idTransaction, com.ensa.entities.Compte compte, double montant, Date dateTransaction,
			Date dateDebit) {
		super();
		this.idTransaction = idTransaction;
		Compte = compte;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		this.dateDebit = dateDebit;
	}
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Compte getCompte() {
		return Compte;
	}
	public void setCompte(Compte compte) {
		Compte = compte;
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
	public Date getDateDebit() {
		return dateDebit;
	}
	public void setDateDebit(Date dateDebit) {
		this.dateDebit = dateDebit;
	}
	
	
	
}
