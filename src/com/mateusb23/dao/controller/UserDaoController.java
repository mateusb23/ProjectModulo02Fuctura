package com.mateusb23.dao.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.mateusb23.connection.ConnectionFactory;
import com.mateusb23.dao.UserDAO;
import com.mateusb23.model.entities.User;

public class UserDaoController extends UserDAO {

	@Override
	public void save(User user) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
