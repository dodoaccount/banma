package com.dt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtilDemo01 {
	public static void main(String[] args) {
		//����  JDBCUtil����������ݿ�����
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Object[]> list = new ArrayList<Object[]>(); // 1��List��װ������������
		try {
			ps = conn.prepareStatement(""); //ִ��1�����ݿ����
			ps.setObject(1, 1);
			rs = ps.executeQuery(); //�������ݿⷴ�����
			
			while(rs.next()){
				// System.out.println(rs.getString(x));
				Object[] objs = new Object[3]; // 1��Object�����װ1�����ݷ�����¼
				objs[0]= rs.getString(1); 
				objs[1]= rs.getObject(2);
				objs[2]= rs.getObject(3);
				
				list.add(objs);  //��list����װ����������
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
