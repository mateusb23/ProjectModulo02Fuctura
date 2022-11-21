package com.mateusb23.dao;

import com.mateusb23.model.entities.Account;

public abstract class AccountDAO extends GenericDAO<Account> {

	public abstract Account findByNumber(Long numberAccount);
	public abstract void depositAmount(Long numberAccount, Double amount);
	public abstract Account passwordCheck(Integer password);
	public abstract void withdrawAmount(Long numberAccount, Double amount);
	
}
