package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.itstep.model.Account;

public class CartDAO {
	public void saveAction(int orderID, Account account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO carts(acclogin, orderID, timeCreation) VALUES(?, ?, ?)";
		
		connection = ConnectionToDB.getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, acclogin);
		statement.setInt(2, orderID);			
		statement.setLong(3, 999999);

}
}
