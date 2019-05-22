package com.wipro.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.bean.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{
	
	Account findByAccountId(Integer id);

}
