package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.empDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete page  is redirected");
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		int state = empDao.delete(id);
		request.setAttribute("deletemessage", state);
		if (state == 1) {
			System.out.println("data deleted");

		}
		request.setAttribute("deletemessage", "data deleted sssssuuuuucccc");
		request.getRequestDispatcher("home.jsp").include(request, response);
;
	}

}
