package com.mateusb23.dao;

public interface AccountDAO<Account> {

	Account findByNumber(Long numberAccount);
	
}
