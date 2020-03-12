package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.empBean;
import com.dao.empDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("please login properly to get page");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

		response.setHeader("Pragma","no-cache");

		response.setHeader("Expires", "0");
		HttpSession session = null;
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		empBean specificuser = empDao.getEmployeeByUsername(name);
		System.out.println("userbname is " + specificuser.getUsername());
		System.out.println("password is " + specificuser.getPassword());

		// test for no data from database
		if (specificuser.getUsername() == null && specificuser.getPassword() == null) {
			System.out.println("no data ");
			out.println("please enter correct username or password ");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}

		// compare database value with request data
		if (name.equalsIgnoreCase(specificuser.getUsername())
				&& password.equalsIgnoreCase(specificuser.getPassword())) {

			// checking if admin admin is added
			if (password.equals("admin") && name.equalsIgnoreCase("admin")) {

				List<empBean> list = empDao.getAllEmployees();
				if (list == null) {
					System.out.println("list is not displyed");
				} else {
					System.out.println("list is displayed ");
					for(empBean e :list)
					{
						System.out.print(e.getUsername());
						System.out.print(e.getId());
					}
				}

				 session = request.getSession();
				session.setAttribute("adminname", name);

				response.sendRedirect("home.jsp");
			}
			// if no admin is there
			else {
				
				
				request.getSession().setAttribute("username", specificuser.getUsername());
				
				

				response.sendRedirect("user.jsp");

			}

		} else {
			System.out.println("username or password mismatched  ");
			response.sendRedirect("index.jsp");

		}
	}

}
