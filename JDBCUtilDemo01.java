package com.dt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtilDemo01 {
	public static void main(String[] args) {
		//建立  JDBCUtil工具类的数据库连接
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Object[]> list = new ArrayList<Object[]>(); // 1个List封装多条数组数据
		try {
			ps = conn.prepareStatement(""); //执行1条数据库语句
			ps.setObject(1, 1);
			rs = ps.executeQuery(); //返回数据库反馈结果
			
			while(rs.next()){
				// System.out.println(rs.getString(x));
				Object[] objs = new Object[3]; // 1个Object数组封装1条数据反馈记录
				objs[0]= rs.getString(1); 
				objs[1]= rs.getObject(2);
				objs[2]= rs.getObject(3);
				
				list.add(objs);  //向list里面装载数组数据
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		for(Object[] objs:list){
			
			System.out.println(""+objs[0]+objs[1]+objs[2]);
		}
		
	}

}
