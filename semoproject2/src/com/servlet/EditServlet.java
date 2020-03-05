package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.empBean;
import com.dao.empDao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit page  is redirected");
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		empBean eb = empDao.getEmployeeById(id);
		request.getSession().setAttribute("eb", eb);
		request.getRequestDispatcher("registration.jsp").include(request, response);
	}

}
