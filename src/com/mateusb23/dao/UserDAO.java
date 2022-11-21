package com.mateusb23.dao;

import com.mateusb23.model.entities.User;

public abstract class UserDAO extends GenericDAO<User> {

	public abstract User findByCpf(String cpf);
	
}
