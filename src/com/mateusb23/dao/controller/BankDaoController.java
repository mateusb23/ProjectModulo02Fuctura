package com.mateusb23.dao.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.BankDAO;
import com.mateusb23.model.entities.BankingInstitution;

public class BankDaoController extends BankDAO {

	@Override
	public void save(BankingInstitution bank) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
		try {
			em.getTransaction().begin();
			if (bank.getId() == null) {
				em.persist(bank);
			} else {
				em.merge(bank);
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
	public BankingInstitution findById(Integer id) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
		BankingInstitution bank = null; 
		
		try {
			bank = em.find(BankingInstitution.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return bank;
	}

	@Override
	public List<BankingInstitution> findAll() {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
		List<BankingInstitution> banks = null;
		
		try {
			banks = em.createQuery("from TB_BANK").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return banks;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = new ConnectionFactory().getEntityManager();

		try {
			em.getTransaction().begin();
			if (findById(id) != null) {
				em.remove(id);
			} else {
				System.out.println("Sorry, this banking institution does not exist. "
						+ "\nCheck out the full list of banks below: \n"
						+ findAll());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}



}
