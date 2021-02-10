package com.example.TokenFirstCrud.dto;

public class BankDTO {

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
		return "BankDTO [bankid=" + bankid + ", bankname=" + bankname + ", bankaddress=" + bankaddress + ", token="
				+ token + "]";
	}
	public BankDTO(long bankid, String bankname, String bankaddress, String token) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.bankaddress = bankaddress;
		this.token = token;
	}
	public BankDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	
	
	
	
}
