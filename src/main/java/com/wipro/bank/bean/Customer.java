package com.wipro.bank.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4763276787385275917L;

	public Customer() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer customerId;
	
	private String name;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + "]";
	}
	
}
