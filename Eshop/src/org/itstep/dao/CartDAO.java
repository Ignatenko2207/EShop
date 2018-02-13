package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.itstep.model.Account;
import org.itstep.model.Action;
import org.itstep.model.Cart;

public class CartDAO {
	public void saveCart(int orderID, Account account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO carts(acclogin, orderID, timeCreation) VALUES(?, ?, ?)";
		
	try {	
		connection = ConnectionToDB.getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, account.getLogin());
		statement.setInt(2, orderID);
		Date dtame = new Date();			
		statement.setLong(3, dtame.getTime());
		
		statement.executeUpdate();
		
	} catch (SQLException e) {			
		e.printStackTrace();
	}
	finally {
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
	public Cart getCartLogin(Account account) {
				
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM cart WHERE login=?";
						
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getLogin());
			resultSet = statement.executeQuery();
			while (resultSet.next())
			{
				action.setAsin(resultSet.getString("asin"));
				action.setLogin(resultSet.getString("login"));
				action.setAction(resultSet.getString("action"));
				action.setActionTime(resultSet.getLong("action_time"));
															
			}					
		} catch (SQLException e) {					
			e.printStackTrace();
		}				
		finally {					
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
		return action;					
}
	
	
	
}

