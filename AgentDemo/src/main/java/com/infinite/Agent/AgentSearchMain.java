package com.infinite.Agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearchMain {
	public static void main(String[] args) {
		int agentid;
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the agent id");
		agentid=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","india@123");
			String cmd= "select * from Agent where AgentID=?";
			PreparedStatement pst= con.prepareStatement(cmd);
			pst.setInt(1,agentid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				System.out.println("AgentId "+rs.getString("AgentID"));
				System.out.println("Name "+rs.getString("Name"));
				System.out.println("City " +rs.getString("City"));
				//System.out.println("Gender "+rs.getString("gender"));
				System.out.println("MeritalStatus " +rs.getInt("MaritalStatus"));
				System.out.println("Premium "+rs.getInt("Premium"));
			}else{
				System.out.println("*** Record not Found***");
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
