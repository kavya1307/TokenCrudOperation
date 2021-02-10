package com.example.TokenFirstCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TokenFirstCrud.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{


	Bank findByToken(String token);

	boolean existsBytoken(String token);

}
