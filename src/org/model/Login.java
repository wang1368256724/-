package org.model;

public class Login {
	private Integer id;
	private String name;
	private String password;
	private Integer role;
	private String lastlogin;
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", lastlogin="
				+ lastlogin + "]";
	}
	
}
