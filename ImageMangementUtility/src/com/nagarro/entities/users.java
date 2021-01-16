package com.nagarro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * getter of user information
 * pojo
 * 
 *
 */
@Entity
@Table(name = "credentials")

public class users 
{
	@Id 
	@Column(name = "username")
	private String username;
	@Column(name = "userpassword")
	private String pasword;
	public users(String username, String password)
	
	{
		super();
		this.username = username;
		
	}
	
	public users()
	{
		
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	
	

}
