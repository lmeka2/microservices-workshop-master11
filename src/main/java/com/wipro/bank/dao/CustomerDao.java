package com.wipro.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.bean.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(Integer id);
	
}
