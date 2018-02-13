package org.itstep.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.dao.DBConnection;
import org.itstep.model.Good;
import org.itstep.model.Good;


public class GoodDao {
	public void save(Good good) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO goods (artNo, name, price) VALUES(?,?,?)";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, good.getArtNo());
			statement.setString(2, good.getName());
			statement.setLong(3, good.getPrice());
			
			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public Good get(String artNo) {

		Good good = new Good(artNo, artNo, 0);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM goods WHERE artNo=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, artNo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				good.setArtNo(resultSet.getString("asin"));
				good.setName(resultSet.getString("name"));
				good.setPrice(resultSet.getInt("price"));
				
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
		return good;
	}
	
	
	public void update(String asin, Good newGood) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE goods SET artNo=?, name=?, price=? WHERE artNo=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(6, asin);

			statement.setString(1, newGood.getArtNo());
			statement.setString(2, newGood.getName());
			statement.setLong(3, newGood.getPrice());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String artNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM goods WHERE artNo=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, artNo);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
}
