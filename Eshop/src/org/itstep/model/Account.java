package org.itstep.model;

public class Account {

	private String firstName;
	private String secondName;
	private String login;
	private String password;
	private String role;
	private String age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Account(String firstName, String secondName, String login, String password, String role, String age) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.login = login;
		this.password = password;
		this.role = role;
		this.age = age;

	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
}
