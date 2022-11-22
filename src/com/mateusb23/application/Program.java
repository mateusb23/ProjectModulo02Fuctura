package com.mateusb23.application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mateusb23.dao.controller.AccountDaoController;
import com.mateusb23.dao.controller.BankDaoController;
import com.mateusb23.model.entities.Account;
import com.mateusb23.model.entities.BankingInstitution;
import com.mateusb23.model.entities.User;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		AccountDaoController accountDaoController = new AccountDaoController();
		
	/*	User user1 = new User("Fiódor Dostoiévski", "M", "201.471.525-42", "09/04/2019");
		User user2 = new User("Safira Gordinha", "F", "126.171.655-82", "20/10/2013");
		User user3 = new User("Mel Velhinha", "F", "345.258.363-50", "20/10/2013");
		User user4 = new User("Lepe Peludo", "M", "227.363.738-12", "17/02/2010");
		
		BankingInstitution bank1 = new BankingInstitution("Bradesco", "60.746.948/0001-12");
		BankingInstitution bank2 = new BankingInstitution("Safra", "58.160.789/0001-28");
		BankingInstitution bank3 = new BankingInstitution("Caixa", "00.360.305/0001-04");
		BankingInstitution bank4 = new BankingInstitution("Banco do Brasil", "00.000.000/0001-91");
		BankingInstitution bank5 = new BankingInstitution("Banco do Nordeste", "07.237.373/0001-20");
		BankingInstitution bank6 = new BankingInstitution("Itaú", "60.701.190/0001-04");
		
		Account account1 = new Account(8949549L, 45000.70, 3349, user1, bank1);
		Account account2 = new Account(4539583L, 3890.56, 4506, user1, bank3);
		Account account3 = new Account(5475675L, 89003.88, 9948, user2, bank6);
		Account account4 = new Account(1029433L, 780.56, 2331, user3, bank3);
		Account account5 = new Account(2342556L, 200588.14, 7416, user4, bank2);
		Account account6 = new Account(7877609L, 132.84, 5322, user1, bank4);
		Account account7 = new Account(3453466L, 789450.43, 3190, user3, bank5);
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		accounts.add(account5);
		accounts.add(account6);
		accounts.add(account7);
		
		accounts.forEach(accountDaoController::save);  */
		
		System.out.println(accountDaoController.findAll());		
		
		/*BankDaoController bankDaoController = new BankDaoController();
		
		System.out.println(bankDaoController.findAll());*/
		
	}
	
}
