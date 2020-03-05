package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.empBean;
import com.util.utility;

public class empDao {
	public static void insertEmployee(empBean eb) throws SQLException {
		System.out.println("under empdao");
		Connection con = utility.getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO emp(username,password,email,date,phnenumber) VALUES (?,?,?,?,?)");
		// name,address,gender,salary,birthDate
		ps.setString(1, eb.getUsername());
		ps.setString(2, eb.getPassword());
		ps.setString(3, eb.getEmail());
		ps.setString(4, (String) eb.getDate().toString());
		ps.setDouble(5, eb.getPhnenumber());

		int status = ps.executeUpdate();
		if (status == 1) {
			System.out.println("data is saved sucesfully");
		}

		con.close();
	}

	public static int update(empBean eb) {
		int status = 0;
		try {

			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update emp set username=?,password=?,email=?,date=?, phnenumber=? where id=?");
			// name,address,gender,salary,birthDate
			ps.setString(1, eb.getUsername());
			ps.setString(2, eb.getPassword());
			ps.setString(3, eb.getEmail());
			ps.setString(4, (String) eb.getDate().toString());
			ps.setDouble(5, eb.getPhnenumber());
			ps.setInt(6, eb.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static empBean getEmployeeById(int id) {
		empBean eb = new empBean();
		System.out.println("employeeDao id " + id);

		try {
			// System.out.println("try");
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			// System.out.println("try");

			while (rs.next()) {
				eb.setId(rs.getInt(1));
				eb.setUsername(rs.getString(2));
				eb.setPassword(rs.getString(3));
				eb.setEmail(rs.getString(4));
				eb.setDate(rs.getString(5));
				eb.setPhnenumber(rs.getDouble(6));

			}

			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return eb;
	}
	
	
	public static empBean getEmployeeByUsername(String username) {
		empBean eb = new empBean();
		

		try {
			// System.out.println("try");
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			// System.out.println("try");

			while (rs.next()) {
				
				eb.setUsername(rs.getString(2));
				eb.setPassword(rs.getString(3));

			}

			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return eb;
	}

	public static int delete(int id) {
		int status = 0;
		// delete from EmployeeSkill15 where employeeId=1014;
		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete  from emp where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			System.out.println("delete id is " + id);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	

	public static List<empBean> getAllEmployees() {
		List<empBean> list = new ArrayList<empBean>();

		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				empBean eb = new empBean();
				eb.setId(rs.getInt(1));
				eb.setUsername(rs.getString(2));
				eb.setPassword(rs.getString(3));
				eb.setEmail(rs.getString(4));
				eb.setDate(rs.getString(5));
				eb.setPhnenumber(rs.getDouble(6));
				//System.out.println("date is " + eb.getDate());
				list.add(eb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return list;
	}
}
