package com.mateusb23.dao.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.AccountDAO;
import com.mateusb23.model.entities.Account;

public class AccountDaoController extends AccountDAO {

	@Override
	public Account findByNumber(Long numberAccount) {
		EntityManager emf = new ConnectionFactory().getEntityManager();

		return null;
	}

	@Override
	public void save(Account account) {
		EntityManager emf = new ConnectionFactory().getEntityManager();
		
		try {
			if (account.getId() == null) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
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

}
