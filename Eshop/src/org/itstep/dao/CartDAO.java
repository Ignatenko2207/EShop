package org.itstep.dao;

import java.sql.*;
import org.itstep.model.*;

public class CartDAO {
	public void saveCart(int orderID, int Id,  Cart cart) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO carts (id, orderID, acclogin, imgUrl, timeCreation) VALUES(?,?,?,?,?)";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cart.getId());
			statement.setInt(2, orderID);
			statement.setString(3, cart.getAccLogin());
			statement.setString(4, cart.getImgUrl());
			statement.setLong(5, cart.getTimeCreation());
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

	public Cart get(String login) {
		Cart cart = get(login);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM carts WHERE login=?";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cart.getId();
				cart.setAccLogin(resultSet.getString("acc_login"));
				cart.setImgUrl(resultSet.getString("img_url"));
				cart.getOrderId();
				cart.setTimeCreation(resultSet.getLong("time_Creation"));
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
		return cart;
	}

}
