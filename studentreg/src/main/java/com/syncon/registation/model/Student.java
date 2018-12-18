package com.syncon.registation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;

@Entity
@Table(name = "Student_Registration")
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "aboutyou")
	private String aboutYou;
	
	@Column(name = "community")
	private String community;
	
	@Transient
	private String community1;
	
	@Transient
	private String community2;
	
	@Transient
	private String community3;
	
	@Transient
	private String password;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAboutYou() {
		return aboutYou;
	}

	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCommunity1() {
		return community1;
	}

	public void setCommunity1(String community1) {
		this.community1 = community1;
	}

	public String getCommunity2() {
		return community2;
	}

	public void setCommunity2(String community2) {
		this.community2 = community2;
	}

	public String getCommunity3() {
		return community3;
	}

	public void setCommunity3(String community3) {
		this.community3 = community3;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", gender=" + gender + ", country=" + country
				+ ", aboutYou=" + aboutYou + ", community=" + community + ", community1=" + community1 + ", community2="
				+ community2 + ", community3=" + community3 + ", password=" + password + "]";
	}

	

	
}
