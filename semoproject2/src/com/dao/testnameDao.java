package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.empBean;
import com.bean.questionbank;
import com.bean.testBean;
import com.util.utility;

public class testnameDao {
	
	
	
	
	public static int inserttest(testBean tb) throws SQLException {
		Connection con = utility.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO testname(test_name,category_id,total_duration,total_questions) VALUES (?,?,?,?)");
		// int test_id,category_id,total_questions;

		// String test_name,total_duration;
		ps.setString(1, tb.getTest_name());
		ps.setInt(2, tb.getCategory_id());
		ps.setString(3, tb.getTotal_duration());
		ps.setInt(4, tb.getTotal_questions());

		int status = ps.executeUpdate();

		return status;
	}

	/*
	 * public static int getLatInsertedID() { int last_id_testname;
	 * 
	 * try { Connection con = utility.getConnection(); PreparedStatement ps = con.
	 * prepareStatement("select test_id from testname where Id=(SELECT LAST_INSERT_ID())"
	 * ); ResultSet rs = ps.executeQuery(); while (rs.next()) { last_id_testname=
	 * rs.getInt(1); }
	 * 
	 * return last_id_testname;
	 * 
	 * 
	 * } }
	 */
	
	public static int getLastInsertedID() throws Exception
	{
		 int last_id_testname = 0;
		Connection con = utility.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT test_id  FROM testname ORDER BY test_id DESC LIMIT 1" );
		ResultSet rs = ps.executeQuery();
		while (rs.next()) { 
			last_id_testname= rs.getInt(1);
			System.out.println(last_id_testname);
			}
		return last_id_testname;
		
	}
	//join operation for from three tables 
	public static List getAlldataforUserTest() {
		List list = new ArrayList();

		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT questionbank.questionname,questionbank.option_a,questionbank.option_b,questionbank.option_c,questionbank.option_d,questionbank.answer,testname.test_name,category.category_name FROM questionbankINNER JOIN testname ON testname.test_id = questionbank.testname_id INNER JOIN category ON testname.category_id = category.category_id  WHERE testname_id = 12");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				list.add(rs.getInt(1));
				list.add(rs.getInt(2));
				list.add(rs.getInt(3));
				list.add(rs.getInt(4));
				list.add(rs.getInt(5));
				list.add(rs.getInt(6));
				list.add(rs.getInt(7));
				list.add(rs.getInt(8));
				//System.out.println("date is " + eb.getDate());
			 System.out.println(list.get(1));	
			 System.out.println(list.get(1));
			 System.out.println(list.get(1));
			 System.out.println(list.get(1));
			 System.out.println(list.get(1));
			 System.out.println(list.get(1));
			 System.out.println(list.get(1));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return list;
	}
	
	
}
