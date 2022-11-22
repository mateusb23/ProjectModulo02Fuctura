package com.mateusb23.dao.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.UserDAO;
import com.mateusb23.model.entities.User;

public class UserDaoController extends UserDAO {

	private EntityManager em = ConnectionFactory.getEntityManager();
	
	@Override
	public void save(User user) {
		
		try {
			em.getTransaction().begin();
			if (user.getId() == null) {
				em.persist(user);
			} else {
				em.merge(user);
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
	public User findById(Integer id) {
		
		User user = null;
		
		try {
			user = em.find(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
		
		return user;
	}

	@Override
	public List<User> findAll() {
		
		List<User> users = null;
		
		try {
			users = em.createQuery("FROM TB_USER").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("COMPLETED OPERATION");
		}
		
		return users;
	}

	@Override
	public void deleteById(Integer id) {
		
		User user = null;
		
		try {
			em.getTransaction().begin();
			user = findById(id);
			if (user != null) {
				em.remove(user);
			} else {
				System.out.println("Sorry, this user does not exist.");
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
	public User findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
