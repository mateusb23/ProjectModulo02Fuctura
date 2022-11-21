package com.mateusb23.application;

import com.mateusb23.dao.controller.AccountDaoController;
import com.mateusb23.model.entities.Account;

public class Program {

	public static void main(String[] args) {
		
		AccountDaoController accountDaoController = new AccountDaoController();
		
		Account account1 = new Account(8949549L, 45000.70, null, null, null);
		
		accountDaoController.save(account1);
	}
	
}
