package org.itstep.model;

public class Account {

	private String FirstName;
	private String SecondName;
	private String Login;
	private String Password;
	private String Role;
	private String Age;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getSecondName() {
		return SecondName;
	}

	public void setSecondName(String secondName) {
		this.SecondName = secondName;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		this.Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public Account(String firstName, String secondName, String login, String password, String role, String age) {
		this.FirstName = firstName;
		this.SecondName = secondName;
		this.Login = login;
		this.Password = password;
		this.Role = role;
		this.Age = age;
	}

}
