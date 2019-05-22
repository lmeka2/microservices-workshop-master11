package com.wipro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.bean.FundTransferRequest;
import com.wipro.bank.bean.FundTransferResponse;
import com.wipro.bank.service.AccountService;

@RestController
public class AccountServicesController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/addAccount")
	public String addAccount(@RequestBody Account request) {
		if(request == null) {
			return "Empty Object Received";
		}else {
			return accountService.addAccount(request);
		}
	}

	@RequestMapping(value = "/getBalance")
	public String getBalance(@RequestParam(name = "accountId") String accountId) {
		return accountService.getBalance(accountId);
	}

	@RequestMapping(value = "/getAllAccounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}

	@RequestMapping(value = "/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return accountService.getAllCustomers();
	}

	@RequestMapping(value = "/transferFunds")
	public FundTransferResponse transferFunds(@RequestBody FundTransferRequest request) {
		return accountService.transferFunds(request); 
	}

}
