package com.mateusb23.model.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_BANK")
@DynamicUpdate
public class BankingInstitution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BANK", nullable = false)
	private Integer id;
	@Column(name = "BANK_NAME", nullable = false)
	private String bankname;
	@Column(name = "CNPJ", nullable = false)
	private String cnpj;
	
	public BankingInstitution() { }
	
	public BankingInstitution(String bankname, String cnpj) {
		this.bankname = bankname;
		this.cnpj = cnpj;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BankingInstitution [id=" + id + ", bankname=" + bankname + ", cnpj=" + cnpj + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankingInstitution other = (BankingInstitution) obj;
		return Objects.equals(id, other.id);
	}
	
}
