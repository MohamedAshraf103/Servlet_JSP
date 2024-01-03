package com.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Product;
import com.managers.DBManager;

public class ProductRepo {

	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	private static ArrayList<Product> list = null;
	private static Product product = null;
	private static int result = 0;

	public static ArrayList<Product> findAllProducts() {
		list = new ArrayList<Product>();
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement("select * from Product");
			res = stmt.executeQuery();
			while (res.next()) {
				product = new Product(res.getInt("id"), res.getString("name"), res.getString("price"),
						res.getString("category"), res.getString("description"));
				list.add(product);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.closeResultSet(res);
			DBManager.closeStatement(stmt);
			DBManager.closeConnection(conn);
		}
		return list;
	}

	public static int add(Product p) {
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement("insert into Product(name,price,category,description) values(?,?,?,?)");
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getPrice());
			stmt.setString(3, p.getCategory());
			stmt.setString(4, p.getDescription());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.closeStatement(stmt);
			DBManager.closeConnection(conn);
		}
		return result;
	}

}
