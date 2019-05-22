package com.wipro.bank.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2422451993773034068L;

	@Id
	@GeneratedValue
	private Integer accountId;

	private Double balance;

	@OneToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Account() {

	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", customer=" + customer.toString() + "]";
	}

}
