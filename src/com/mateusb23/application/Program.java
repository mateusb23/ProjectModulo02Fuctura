package com.mateusb23.application;

import java.text.ParseException;

import com.mateusb23.dao.controller.AccountDaoController;
import com.mateusb23.model.entities.Account;
import com.mateusb23.model.entities.BankingInstitution;
import com.mateusb23.model.entities.User;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		AccountDaoController accountDaoController = new AccountDaoController();
		
		User user1 = new User("Fiódor Dostoiévski", "M", "201.471.525-42", "09/04/2019");
		
		BankingInstitution bank1 = new BankingInstitution("Bradesco", "27.873.828/0001-00");
		
		Account account1 = new Account(8949549L, 45000.70, 3349, user1, bank1);
		
		accountDaoController.save(account1);
	}
	
}
