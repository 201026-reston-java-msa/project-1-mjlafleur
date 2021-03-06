package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table (name="ERS_USERS") //this is the default and doesn't have to be used because the class is Employee.
public class User{
	
	@Id
	@Column(name="ERS_USERS_ID") //the default column would be "id"
	@GeneratedValue(strategy=GenerationType.IDENTITY) //sets Primary key
	private int userId;
	
	/*GeneratedValue 
	* AUTO(default) pk will be unique.
	* IDENTITY this is used from the @Id annotation. (disables batch updates)
	* SEQUENCE hibernate suggested. Going to use is on roles. Role.java
	* TABLE this is a little beyond me.
	*/
	
	@NotNull //this is handled by Hibernate, HOWEVER, the property Can be changed to false affecting the DB with Null values.
	@Column(name= "ERS_USERNAME",unique=true, nullable=false, length=50) //nullable is not null nut at the database level.
	private String username;
	
	/////////////////////////////////////NEEDS ENCRYPTION/////////////////////////
	@NotNull //this has to be encrypted not really sure how to do this.
	@Column(length=50,name="ERS_PASSWORD")
	private String password;
	
	@NotNull
	@Column(length=100,name="USER_FIRST_NAME")
	private String firstName;
	
	@NotNull
	@Column(length=100,name="USER_LAST_NAME")
	private String lastName;
	
	@NotNull
	@Column(length=150, name="USER_EMAIL", unique=true)
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ROLE_ID")	
	private Role role;

	//CONSTRUCTOR
	public User() {
	}
	
	public User(String username, String password, String firstName, String lastName, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	//GETTER & SETTERS//
	public int getUserId() {
		return userId;
	}

	public void setUserId(int employeeId) {
		this.userId = employeeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	//ToSTRING//
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}

	//HASHCODE//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	//EQUALS//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	

	
}