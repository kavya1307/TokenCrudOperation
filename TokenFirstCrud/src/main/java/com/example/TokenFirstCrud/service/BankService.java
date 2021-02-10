package com.example.TokenFirstCrud.service;

import org.springframework.http.ResponseEntity;

import com.example.TokenFirstCrud.dto.BankDTO;

public interface BankService {
	
	public ResponseEntity<?> createbank(BankDTO dto);
	public ResponseEntity<?> getall();
	public ResponseEntity<?> deletebank(String token);
	public ResponseEntity<?> updatebank(String token,BankDTO dto);
}
