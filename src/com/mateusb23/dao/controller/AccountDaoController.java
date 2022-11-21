package com.mateusb23.dao.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.AccountDAO;
import com.mateusb23.model.entities.Account;

public class AccountDaoController extends AccountDAO {

	@Override
	public void save(Account account) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
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
			em.close();
		}
	}

	@Override
	public Account findById(Integer id) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
		Account account = null;
		
		try {
			account = em.find(Account.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return account;
	}

	@Override
	public List<Account> findAll() {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
		List<Account> accounts = null;
		
		try {
			accounts = em.createQuery("from TB_ACCOUNT").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return accounts;
	}

	@Override
	public void removeById(Integer id) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
		try {
			em.getTransaction().begin();
			if (findById(id) != null) {
				em.remove(id);
			} else {
				findAll();
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	@Override
	public Account findByNumber(Long numberAccount) {
		EntityManager em = new ConnectionFactory().getEntityManager();

		return null;
	}

}
