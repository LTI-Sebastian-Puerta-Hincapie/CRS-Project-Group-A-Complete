package com.lti.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Role implements Serializable {

	private int roleId;
	private String roleName;
	private String description;
	
	public Role() {}
	
	public Role(int roleId, String roleName, String description) {

		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
