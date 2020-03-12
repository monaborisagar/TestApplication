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
import com.util.utility;

public class QuestionbankDao {
	public static int insertQuestion(questionbank qb) throws SQLException {
		Connection con = utility.getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO questionbank(questionname,option_a,option_b,option_c,option_d,answer,testname_id) VALUES (?,?,?,?,?,?,?)");
		// name,address,gender,salary,birthDate
		ps.setString(1, qb.getQuestionname());
		ps.setString(2, qb.getOption_a());
		ps.setString(3, qb.getOption_b());
		ps.setString(4, qb.getOption_c());
		ps.setString(5, qb.getOption_d());
		ps.setString(6, qb.getAnswer());
		ps.setInt(7, qb.getTestname_id());
		int status = ps.executeUpdate();
		if (status == 1) {
			System.out.println("questionbank is saved sucesfully");
		}

		return status;
	}

	
}
