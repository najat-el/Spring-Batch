package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Compte;
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{
	Compte findByIdCompte(long id);

}
