package com.example.TokenFirstCrud.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.catalina.mapper.Mapper;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TokenFirstCrud.dto.BankDTO;
import com.example.TokenFirstCrud.model.Bank;
import com.example.TokenFirstCrud.repository.BankRepository;
import com.example.TokenFirstCrud.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankRepository repository;

	@Override
	public ResponseEntity<?> createbank(BankDTO dto) {
		Map<String, Object> map = new HashMap<String , Object>();
		
		Bank bank = new Bank();
		String bankname = dto.getBankname();
		String bankaddress = dto.getBankaddress();

		if (dto.getBankid()>0) {
			
			bank.setBankid(dto.getBankid());
		}
		if(bankname.isEmpty())
		{
			map.put("code", 404);
			map.put("message", "bankname is empty...");
			map.put("status", false);
			map.put("bankname", bankname);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(map);

		}
		if(bankaddress.isEmpty())
		{
			map.put("code", 404);
			map.put("message", "bankaddress is empty...");
			map.put("status", false);
			map.put("bankaddress", bankaddress);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(map);
		}
		else {
		ModelMapper modelMapper = new ModelMapper();
		Bank bank2 = modelMapper.map(dto, Bank.class);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Bankid",bank.getBankid());
		map1.put("bankname", dto.getBankname());
		map1.put("bankaddress", dto.getBankaddress());
		
		
		map.put("code", 200);
		map.put("message", "data inserted....");
		map.put("status", true);
		map.put("data", repository.save(bank2));
		return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
		
	}

	@Override
	public ResponseEntity<?> getall() {
		List<Bank> list = repository.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("message", "get all bank...");
		map.put("status", true);
		map.put("data", list);
		
		return ResponseEntity.ok(map);
	}

	@Override
	public ResponseEntity<?> deletebank(String token) {
		Bank bank = repository.findByToken(token);
		Map<String, Object> map = new HashMap<String, Object>();
		if (!repository.existsBytoken(token)) {
			map.put("code", 404);
			map.put("message", "Userid not found");
			map.put("status", false);
			map.put("userid", token);
			return ResponseEntity.ok(map);
		} else {

			map.put("code", 200);
			map.put("message", "Delete Successfully");
			map.put("status", true);
			map.put("deleted-data", token);
			repository.delete(bank);
			map.put("above data", "deleted");
			return ResponseEntity.ok(map);
		}
		
	
	} 

	@Override
	public ResponseEntity<?> updatebank(String token, BankDTO dto) {
	Map<String, Object> map = new HashMap<String , Object>();
		
		Bank bank = new Bank();
		String bankname = dto.getBankname();
		String bankaddress = dto.getBankaddress();

		if (dto.getBankid()>0) {
			
			bank.setBankid(dto.getBankid());
		}
		if(bankname.isEmpty())
		{
			map.put("code", 404);
			map.put("message", "bankname is empty...");
			map.put("status", false);
			map.put("bankname", bankname);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(map);

		}
		if(bankaddress.isEmpty())
		{
			map.put("code", 404);
			map.put("message", "bankaddress is empty...");
			map.put("status", false);
			map.put("bankaddress", bankaddress);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(map);
		}
		else {
		ModelMapper modelMapper = new ModelMapper();
		Bank bank2 = modelMapper.map(dto, Bank.class);
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("Bankid",bank.getBankid());
//		map1.put("bankname", dto.getBankname());
//		map1.put("bankaddress", dto.getBankaddress());
//		
//		
		map.put("code", 200);
		map.put("message", "data updated....");
		map.put("status", true);
		map.put("data", repository.save(bank2));
		return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
		
	}
	
	
}
