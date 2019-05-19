package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.ResolutionSyntax;

import org.itstep.model.Order;

public class OrderDAO {
	public void saveOrder(Order order) {

		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO order (orderId, good, amount) VALUES(?,?,?)";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, order.getOrderId());
			statement.setString(2, order.getGood());
			statement.setInt(3, order.getAmount());

			statement.executeUpdate();
			statement.close();
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

	public Order get(Long orderId, String good) {
		Order order = new Order();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM order WHERE orderId=? AND good=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, orderId);
			statement.setString(2, good);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				order.setOrderId(resultSet.getLong("orderId"));
				order.setGood(resultSet.getString("good"));
				order.setAmount(resultSet.getInt("amount"));
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
		return order;

	}

	public void updete(Long orderId, String good, Order newOrder) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE order SET orderId=?, good=?, amount=? WHERE order=? AND good=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, orderId);
			statement.setString(2, good);

			statement.setLong(1, newOrder.getOrderId());
			statement.setString(2, newOrder.getGood());
			statement.setInt(3, newOrder.getAmount());

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

	public void delete(Long orderId, String good) {

		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM order WHERE orderId=? AND good=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, orderId);
			statement.setString(2, good);
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