package com.mateusb23.dao;

import java.util.List;

public abstract class GenericDAO<T> {

	public abstract void save(T obj);
	public abstract T findById(Integer id);
	public abstract List<T> findAll();
	public abstract void deleteById(Integer id);
	
}
