package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Compte {
	@Id
	private Long idCompte;
	private double solde;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(Long idCompte, double solde) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
	}
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	

}
