package com.infinite.Agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentShowMain {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","india@123");
			System.out.println("Connected..");
			String cmd= "select * from Agent";
			PreparedStatement pst= con.prepareStatement(cmd);
			ResultSet rs= pst.executeQuery();
			while(rs.next()){
				System.out.println("AgentId "+rs.getString("AgentID"));
				System.out.println("Name "+rs.getString("Name"));
				System.out.println("City " +rs.getString("City"));
				//System.out.println("Gender "+rs.getString("gender"));
				System.out.println("MeritalStatus " +rs.getInt("MaritalStatus"));
				System.out.println("Premium "+rs.getDouble("Premium"));
				System.out.println("--------------------------");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
