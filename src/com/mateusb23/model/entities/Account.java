package com.mateusb23.model.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_ACCOUNT")
@DynamicUpdate
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACCOUNT")
	private Integer id;
	@Column(name = "NM_ACCOUNT", nullable = false, unique = true)
	private Long numAccount;
	@Column(name = "BALANCE", nullable = false)
	private Double balance;
	@Column(name = "PASSWORD", nullable = false)
	private Integer password;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_BANK", nullable = false, referencedColumnName = "ID_BANK")
	private BankingInstitution bank;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USER", nullable = false, referencedColumnName = "ID_USER")
	private User user;
	
	public Account () { }

	public Account(Long numAccount, Double balance, Integer password, User user, BankingInstitution bank) {
		this.numAccount = numAccount;
		this.balance = balance;
		this.password = password;
		this.user = user;
		this.bank = bank;
	}

	public Long getNumAccount() {
		return numAccount;
	}

	public void setNumAccount(Long numAccount) {
		this.numAccount = numAccount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public BankingInstitution getBank() {
		return bank;
	}

	public void setBank(BankingInstitution bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", numAccount=" + numAccount + ", balance=" + balance + ", password=" + password
				+ ", bank=" + bank + ", user=" + user + "]";
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
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
