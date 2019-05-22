package com.wipro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.bean.FundTransferRequest;
import com.wipro.bank.bean.FundTransferResponse;
import com.wipro.bank.dao.AccountDao;
import com.wipro.bank.dao.CustomerDao;

@Service
public class AccountService {
	
	org.slf4j.Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CustomerDao customerDao;

	public List<Account> getAllAccounts(){
		List<Account> response = accountDao.findAll();
		if(response.size()>0) {
			response.forEach(ac -> LOG.info(ac.toString()));
		}else {
			LOG.info("Unable to Fetch Account");
			response = new ArrayList<>();
		}
		return response;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> response = customerDao.findAll();
		if(response.size()>0) {
			response.forEach(custom -> LOG.info(custom.toString()));
		}else {
			LOG.info("Unable to Fetch Account");
			response = new ArrayList<>();
		}
		return response;
	}
	
	@Transactional
	public String addAccount(Account acc) {
		LOG.info("Add Account Service Invoked Request Object"+ acc.toString());
		StringBuilder response = new StringBuilder();
		
		//To check if New Customer
		Customer updatedCustomer = customerDao.findByCustomerId(acc.getCustomer().getCustomerId());
		if(updatedCustomer != null) {
			Customer request = acc.getCustomer();
			request.setCustomerId(updatedCustomer.getCustomerId());
			acc.setCustomer(request);
		}
		Customer saveNewCustomer = customerDao.save(acc.getCustomer());
		acc.setCustomer(saveNewCustomer);
		
		Account accountAfterSave = accountDao.save(acc);
		if(accountAfterSave != null) {
			response.append("Saved " + accountAfterSave.toString());
			LOG.info("Account Saved Successfully "+ accountAfterSave.toString());
		}else {
			response.append("Unable To Save Reqeust Object ");
			LOG.info("Account Save Failed ");
		}
		return response.toString();
	}

	public String getBalance(String accountId) {
		LOG.info("Get Account Balance Service Invoked for Account Id ::"+ accountId);
		StringBuilder response = new StringBuilder();
		if(accountId.isBlank() || accountId.isEmpty()) {
			return "Invalid Request Parameter";
		}
		try {
			Account acc = accountDao.findByAccountId(Integer.valueOf(accountId));
			if(acc != null) {
				LOG.info("Account Details ::"+ acc.toString());
				response.append("Account Balance For Id "+ accountId + " is:: " +acc.getBalance());
			}else {
				response.append("No Account Found For Id "+ accountId);
			}
		}catch(NumberFormatException e) {
			response.append("Invalid Account Id Format, Expected Integer Request");
		}
		return response.toString();
	}
	
	@Transactional
	public FundTransferResponse transferFunds(FundTransferRequest request) {
		FundTransferResponse response = new FundTransferResponse();
		LOG.info("Request Object ::" + request.toString());
		Account sourceAccount = null;
		Account destinationAccount = null;
		try {
			sourceAccount = accountDao.findByAccountId(request.getSourceAccount());
			destinationAccount = accountDao.findByAccountId(request.getDestinationAccount());
			if(sourceAccount == null) {
				LOG.error("Source Account Doesnot Exists");
				response.setStatus("Source Account with Account Id:" + request.getSourceAccount() + " doesnot Exists");
			}else if(destinationAccount == null) {
				LOG.error("Desitnation Account Doesnot Exists");
				response.setStatus("Destination Account with Account Id : " + request.getDestinationAccount() + " doesnot Exists");
			}else {
				if(sourceAccount.getBalance() > request.getBalance()) {
					Double sourceBalance = (sourceAccount.getBalance() -  request.getBalance());
					Double destinationBalance = (destinationAccount.getBalance() + request.getBalance());
					sourceAccount.setBalance(sourceBalance);
					destinationAccount.setBalance(destinationBalance);
					Account updatedSource = accountDao.save(sourceAccount);
					Account updatedDestination = accountDao.save(destinationAccount);
					if(updatedSource == null || updatedDestination == null ) {
						LOG.error("Something went Wrong..!");
						throw new Exception();
					}else {
						LOG.info("Updated Source " + updatedSource.toString());
						LOG.info("Updated Destination " + updatedDestination.toString());
						response.setStatus("Fund Sucessfully Transferred");
						response.setSourceAccountBalance(updatedSource.getBalance());
						response.setDestinationAccountBalance(updatedDestination.getBalance());
						response.setTransferedAmount(request.getBalance());
					}
				}else {
					LOG.error("Insufficient Balance in Account");
					response.setStatus("Insufficient Balance in Account with Account Id:" + request.getSourceAccount() + " with Balance: " + sourceAccount.getBalance());
				}
			}
		}catch(Exception e) {
			response.setStatus("Something went Wrong..! Please Try Again Later");
			LOG.error(e.getStackTrace().toString());
		}
		return response;
	}
	
}
