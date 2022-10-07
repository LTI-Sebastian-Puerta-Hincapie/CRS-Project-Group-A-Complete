package com.lti.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {
	
	private int id;
	private String username;
	private String password;
	private int roleId;
	
	public User() { }
	
	public User(int id, String username, String password, int roleId) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
