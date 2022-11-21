package com.mateusb23.dao.controller;

import java.util.List;

import com.mateusb23.dao.AccountDAO;
import com.mateusb23.dao.GenericDAO;

public class AccountDaoController<Account> extends GenericDAO<Account> implements AccountDAO<Account> {

	@Override
	public void save(Account obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findByNumber(Long numberAccount) {
		// TODO Auto-generated method stub
		return null;
	}

}
