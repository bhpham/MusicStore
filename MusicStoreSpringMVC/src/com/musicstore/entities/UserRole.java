package com.musicstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequrIDKey")
	@SequenceGenerator(name = "sequrIDKey", sequenceName = "SEQ_URID_KEY", allocationSize = 1)
	private int userRoleId;
	
	private String userRoleName;
	
	
	public UserRole() {}

	public UserRole(int userRoleId, String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}
	
	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}


}
