package com.mateusb23.dao;

import com.mateusb23.model.entities.BankingInstitution;

public abstract class BankDAO extends GenericDAO<BankingInstitution> {

	public abstract BankingInstitution findByCnpj(String cnpj);
	
}
