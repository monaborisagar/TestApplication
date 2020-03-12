package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.categoryBean;
import com.bean.empBean;
import com.util.utility;

public class categoryDao {
	

	public static List<categoryBean> getAllCategory() {
		List<categoryBean> list = new ArrayList<categoryBean>();

		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				categoryBean cb = new categoryBean();
				
				cb.setCategory_id(rs.getInt(1));
				cb.setCategory_name(rs.getString(2));
				//System.out.println("date is " + eb.getDate());
				list.add(cb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return list;
	}
}
