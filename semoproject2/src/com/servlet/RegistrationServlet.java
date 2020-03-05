package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.empBean;
import com.dao.empDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		String date = request.getParameter("date");

		String phnenumberString = request.getParameter("phnenumber");
		double phnenumber = Double.parseDouble(phnenumberString);

		empBean eb = new empBean();
		eb.setUsername(username);
		eb.setPassword(password);
		eb.setEmail(email);
		eb.setDate(date);
		System.out.println(eb.getDate());
		eb.setPhnenumber(phnenumber);

		try {
			empDao.insertEmployee(eb);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// session.setAttribute("name", null);
		
		out.println("registration done successfully");
		request.setAttribute("success", "data registered successfully");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); 
        dispatcher.forward(request, response);

	}

}
