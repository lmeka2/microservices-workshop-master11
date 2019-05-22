package com.wipro.bank.bean;

public class FundTransferResponse {
	
	private String status;
	
	private Double transferedAmount;
	
	private Double sourceAccountBalance;
	
	private Double destinationAccountBalance;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTransferedAmount() {
		return transferedAmount;
	}

	public void setTransferedAmount(Double transferedAmount) {
		this.transferedAmount = transferedAmount;
	}

	public Double getSourceAccountBalance() {
		return sourceAccountBalance;
	}

	public void setSourceAccountBalance(Double sourceAccountBalance) {
		this.sourceAccountBalance = sourceAccountBalance;
	}

	public Double getDestinationAccountBalance() {
		return destinationAccountBalance;
	}

	public void setDestinationAccountBalance(Double destinationAccountBalance) {
		this.destinationAccountBalance = destinationAccountBalance;
	}

	@Override
	public String toString() {
		return "FundTransferResponse [status=" + status + ", transferedAmount=" + transferedAmount
				+ ", sourceAccountBalance=" + sourceAccountBalance + ", destinationAccountBalance="
				+ destinationAccountBalance + "]";
	}
	
}
