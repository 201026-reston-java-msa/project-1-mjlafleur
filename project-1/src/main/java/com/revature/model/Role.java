package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ERS_USER_ROLES")
public class Role {
	
	@Id
	@Column(name="ERS_USER_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ERS_USER_ROLE_ID") //must Match 
	@SequenceGenerator(name = "ERS_USER_ROLE_ID",initialValue=100, allocationSize=1)   
	private int roleId;
	
	@Column(name="USER_ROLES",length=10)
	private String roleName;
	
	//CONSTRUCTOR///
	public Role() {
	}
	
	public Role(int roleId) {
		this.roleId = roleId;
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	//GETTERS & SETTERS//
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	//ToSTRING//
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
	
}
