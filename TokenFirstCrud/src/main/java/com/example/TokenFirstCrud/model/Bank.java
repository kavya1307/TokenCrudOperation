package com.example.TokenFirstCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankid;
	private String bankname;
	private String bankaddress;
	private String token;
	public long getBankid() {
		return bankid;
	}
	public void setBankid(long bankid) {
		this.bankid = bankid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankaddress() {
		return bankaddress;
	}
	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Bank [bankid=" + bankid + ", bankname=" + bankname + ", bankaddress=" + bankaddress + ", token=" + token
				+ "]";
	}
	public Bank(long bankid, String bankname, String bankaddress, String token) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.bankaddress = bankaddress;
		this.token = token;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
