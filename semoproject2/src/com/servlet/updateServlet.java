package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.empBean;
import com.dao.empDao;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		empBean eb = new empBean();
		System.out.println("update is redirected");
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String phnenumberString = request.getParameter("phnenumber");
		double phnenumber = Double.parseDouble(phnenumberString);

		eb.setId(id);
		eb.setUsername(username);
		eb.setPassword(password);
		eb.setEmail(email);
		eb.setDate(date);
		eb.setPhnenumber(phnenumber);

		int state = empDao.update(eb);
		System.out.println("state is " + state);
		if (state == 1) {
			request.setAttribute("alert", "data updated successfully!!!!");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
			out.println("data updated successfully");
		} else {
			out.print("data not saved successfully");
		}
		// session.setAttribute("eb", null);
		
	}

}
