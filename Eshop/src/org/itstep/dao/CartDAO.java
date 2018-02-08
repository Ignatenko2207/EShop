package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.itstep.model.Account;

public class CartDAO {
	public void saveAction(int orderID, Account account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO carts(acclogin, timeCreation) VALUES(?, ?, ?, ?)";

}
}
