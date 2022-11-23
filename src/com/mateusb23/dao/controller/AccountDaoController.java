package com.mateusb23.dao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.AccountDAO;
import com.mateusb23.model.entities.Account;

public class AccountDaoController extends AccountDAO {

	private EntityManager em = ConnectionFactory.getEntityManager();
	
	@Override
	public void save(Account account) {
		
		try {
			em.getTransaction().begin();
			if (account.getId() == null) {
				em.persist(account);
			} else {
				em.merge(account);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
	}

	@Override
	public Account findById(Integer id) {
		
		Account account = null;
		
		try {
			account = em.find(Account.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
		return account;
	}

	@Override
	public List<Account> findAll() {
		
		List<Account> accounts = new ArrayList<>();
		
		try {
			accounts = em.createQuery("FROM Account").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
		
		return accounts;
	}

	@Override
	public void deleteById(Integer id) {
		
		Account account = null;
		
		try {
			em.getTransaction().begin();
			account = findById(id);
			if (account != null) {
				em.remove(account);
			} else {
				System.out.println("Sorry, this account does not exist.");
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
		
	}
	
	@Override
	public Account findByNumber(Long numberAccount) {
		
		try {
			Query query = em.createQuery("SELECT acc FROM Account acc WHERE numAccount = " + numberAccount);     // Instead of numAccount, we could have written NM_ACCOUNT
			Account account = (Account) query.getSingleResult();
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
		
		return null;
	}

	@Override
	public void depositAmount(Long numberAccount, Double amount) {
		
	}

	@Override
	public Account passwordCheck(Integer password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void withdrawAmount(Long numberAccount, Double amount) {
		// TODO Auto-generated method stub
		
	}

}
