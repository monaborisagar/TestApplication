package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.empBean;
import com.bean.questionbank;
import com.bean.testBean;
import com.dao.QuestionbankDao;
import com.dao.empDao;
import com.dao.testnameDao;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		PrintWriter out = response.getWriter();
		String testname = request.getParameter("testname");
		int selected_category = Integer.parseInt(request.getParameter("category"));
		String test_duration = request.getParameter("test_duration");
		String total = request.getParameter("total_questions");
		int total_questions= Integer.parseInt(total);
		System.out.println(selected_category);

       //seting in testbean
		testBean tb = new testBean();
		tb.setTest_name(testname);
		tb.setCategory_id(selected_category);
		tb.setTotal_duration(test_duration);
		tb.setTotal_questions(total_questions);
		
		
		try {
			int status = testnameDao.inserttest(tb);
			int last_testid = testnameDao.getLastInsertedID();
			if(last_testid!=0)
			{
				
				System.out.println("last testname id is "+last_testid);
				List<questionbank> list1= new ArrayList<questionbank>();
				for(int i=1;i<=total_questions;i++)
				{
					questionbank qb= new questionbank();
					 qb.setQuestionname(request.getParameter("question"+i+""));
					 qb.setOption_a(request.getParameter("a_answer_"+i+""));
					 qb.setOption_b(request.getParameter("b_answer_"+i+""));
					 qb.setOption_c(request.getParameter("c_answer_"+i+""));
					 qb.setOption_d(request.getParameter("d_answer_"+i+""));
					 qb.setAnswer(request.getParameter("correctans_"+i+""));
					 qb.setTestname_id(last_testid);
					 try {
						int status1 = QuestionbankDao.insertQuestion(qb);
						System.out.println("questionbankdata saved successfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("questionbankdata not saved successfully");
					}
				}
				
			}else
			{
				SQLException name = new SQLException();
				name.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
