package com.wipro.bank.bean;

public class FundTransferRequest {

	private Integer sourceAccount;
	
	private Integer destinationAccount;
	
	private Double balance;

	public Integer getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Integer sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Integer getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Integer destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "FundTransferRequest [sourceAccount=" + sourceAccount + ", destinationAccount=" + destinationAccount
				+ ", balance=" + balance + "]";
	}
	
}
