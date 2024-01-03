package com.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.managers.DBManager;
import com.model.User;

public class UserRepo {
	public static ArrayList<User> list=null;
	public static Connection conn = null;
	public static PreparedStatement stmt = null;
	public static ResultSet rs = null;
	public static User user = null;
	public static int res=0;

	private static ArrayList<User> DBLoad()
	{
		list=new ArrayList<User>();
		try {
		        conn = DBManager.getConnection();
	            stmt = conn.prepareStatement("SELECT * from Users");
	            rs = stmt.executeQuery();
	            if (rs.next()) {
	                user = new User();
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                list.add(user);
	            }
	                
		}catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
		
		return list;
	}

	
	public static int userSignUp(User user)
	{
		try {
			conn=DBManager.getConnection();
			stmt=conn.prepareStatement("insert into Users values(?,?,?)");
			stmt.setString(1,user.getName());
			stmt.setString(2,user.getEmail());
			stmt.setString(3,user.getPassword());
			res=stmt.executeUpdate();
		}catch(Exception e){
			e.getMessage();
		}
		finally {
			DBManager.closeStatement(stmt);
			DBManager.closeStatement(stmt);
		}
		
		return res;
	}
	 public static int userLogin(String email, String password) {
	        
	        try {
	        	
	        	list=DBLoad();
	        	for(User user:list)
	        	{
	        		if(user.getEmail().equals(email))
	        		{
	        			if(user.getPassword().equals(password))
	        			{
	        				res=1;
	        				break;
	        			}
	        			else {
	        				res=-2;
	        				break;
	        			}
	        		}
	        		else res=-1;
	        			
	        	}
	        	
	    }catch(Exception e)
	        {
	    		System.out.println(e.getMessage());
	        }
	        
	        return res;
	 }
}
