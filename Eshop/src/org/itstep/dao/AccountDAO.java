package org.itstep.dao;

import java.sql.*;

import org.itstep.model.Account;

public class AccountDAO {

	public void save(Account account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO accounts(first_name, password, second_name, age, role, login) VALUES(?,?,?,?,?,?)";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getFirstName());
			statement.setString(2, account.getPassword());
			statement.setString(3, account.getSecondName());
			statement.setString(4, account.getAge());
			statement.setString(5, account.getRole());
			statement.setString(6, account.getLogin());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Account get(String login) {
		Account account = new Account();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM accounts WHERE login=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				account.setFirstName(resultSet.getString("first_name"));
				account.setSecondName(resultSet.getString("second_name"));
				account.setAge(resultSet.getString("age"));
				account.setPassword(resultSet.getString("password"));
				account.setRole(resultSet.getString("role"));
				account.setLogin(resultSet.getString("login"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return account;
	}

	public void update(String fistName, String secondName, Account newAccount) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE accounts SET first_name=?, second_name=?, login=?, password=? WHERE first_name=? AND second_name=?";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, newAccount.getFirstName());
			statement.setString(2, newAccount.getSecondName());
			statement.setString(3, newAccount.getLogin());
			statement.setString(4, newAccount.getPassword());
			statement.setString(5, fistName);
			statement.setString(6, secondName);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String firstName, String secondName) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM accounts WHERE first_name=? AND second_name=?";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, secondName);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}