package com.mateusb23.model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_USER")
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Integer id;
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "SEXO", nullable = false, length = 1)		// M / F / N
	private String sexo;
	@Column(name = "CPF", nullable = false, length = 14, unique = true)		// 000.000.000-00
	private String cpf;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDATE", nullable = false)
	private Date birthdate;
	
	public User() { }

	public User(String username, String sexo, String cpf, String birthdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.username = username;
		this.sexo = sexo;
		this.cpf = cpf;
		this.birthdate = sdf.parse(birthdate);
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String userName) {
		this.username = userName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + username + ", cpf=" + cpf + ", birthdate=" + birthdate + ", sexo="
				+ sexo + "]";
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
