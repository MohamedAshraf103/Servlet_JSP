package com.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	    private final static String USER_NAME = "root";
	    private final static String PASSWORD = "root";
	    private final static String url="jdbc:mysql://localhost:3306/crud";

	    public static Connection getConnection() throws Exception {
	        Connection conn = null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
	        return conn;
	    }

	    public static void closeConnection(Connection conn) {
	        if (conn == null) {
	            return;
	        }

	        try {
	            conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static void closeStatement(PreparedStatement stmt) {
	        if (stmt == null) {
	            return;
	        }
	        try {
	            stmt.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static void closeResultSet(ResultSet rs) {
	        if (rs == null) {
	            return;
	        }
	        try {
	            rs.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

}
