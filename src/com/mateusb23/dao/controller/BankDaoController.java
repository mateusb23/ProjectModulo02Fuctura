package com.mateusb23.dao.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.BankDAO;
import com.mateusb23.model.entities.BankingInstitution;

public class BankDaoController extends BankDAO {

	private EntityManager em = ConnectionFactory.getEntityManager();
	
	@Override
	public void save(BankingInstitution bank) {
		
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
