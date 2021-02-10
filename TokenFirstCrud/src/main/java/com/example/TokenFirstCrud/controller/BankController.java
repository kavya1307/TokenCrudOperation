package com.example.TokenFirstCrud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TokenFirstCrud.dto.BankDTO;
import com.example.TokenFirstCrud.service.BankService;

@Controller
@RequestMapping("/Bank")
public class BankController {
	
	@Autowired 
	BankService service;

	@PostMapping("/addBank")
	public ResponseEntity<?> addbank(@RequestBody BankDTO dto)
	{
		String uuid = UUID.randomUUID().toString();
		dto.setToken(uuid);
		return service.createbank(dto);
	}
	
	@GetMapping("/getallBank")
	public ResponseEntity<?> getallbank(){
		return service.getall();
	}
	
	@DeleteMapping("/deleteBank/{token}")
	public ResponseEntity<?> deletebank(@RequestParam String token){
		
		return service.deletebank(token);
	}
	
	@PutMapping("/updateBank/{token}")
	public ResponseEntity<?> updatebank(@PathVariable String token,@RequestBody BankDTO dto)
	
	{
		return service.updatebank(token, dto);
	}
}
