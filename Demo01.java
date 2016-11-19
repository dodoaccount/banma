package com.dt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
	public static void main(String[] args) {
		Connection conn =  null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
	        System.out.println(conn);
	        
	        String sql = "select id,name,age from student where id>?";
	        //String sql = "Insert into student (id,name,age) values(?,?,?)";
	        ps = conn.prepareStatement(sql);
	        ps.setObject(1, 3);
	        
	        rs= ps.executeQuery();
	        while(rs.next()){
	        	System.out.println(rs.getObject(1)+"----"+rs.getObject(2)+"----"+rs.getObject(3));
	        }
	        
	        /*ps.setObject(1, 3);
	        ps.setObject(2, "vatorlina");
	        ps.setObject(3, 20);
	        ps.execute();*/
	        
	        
	        /*Statement  stamt = conn.createStatement();
	        String sql = "Insert into student (id,name,age) values(1,'jackMM',18)";
	        stamt.execute(sql);*/
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
			
			
			try {
				if(rs!=null){
				rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				if(ps!=null){
				ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

	}

}
