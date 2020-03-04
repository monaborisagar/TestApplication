package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.startup.HomesUserDatabase;

import com.bean.empBean;
import com.dao.empDao;
import com.util.utility;

/**
 * Servlet implementation class actioncontroller
 */
@WebServlet("/actioncontroller")
public class actioncontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String action = request.getParameter("action");
		// request.getRequestDispatcher("home.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		out.print("please login first");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		 * response.setHeader("Pragma", "no-cache"); response.setHeader("Expires", "0");
		 */
		HttpSession session = request.getSession();
		String tina = "my name is mona";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		System.out.println(action);

		if (action.equalsIgnoreCase("login")) {

			String name = request.getParameter("username");
			String password = request.getParameter("password");
System.out.println(name);
System.out.println(password);
			empBean specificuser = empDao.getEmployeeByUsername(name);
			System.out.println("userbname is " + specificuser.getUsername());
			System.out.println("password is " + specificuser.getPassword());
			
			//test for no data from database
			if (specificuser.getUsername() == null && specificuser.getPassword() == null)
			{
				System.out.println("no data ");
				out.println("please enter correct username or password ");
				request.getRequestDispatcher("index.jsp").include(request, response);     
			}
			
			//compare database value with request data
			if (name.equalsIgnoreCase(specificuser.getUsername())
					&& password.equalsIgnoreCase(specificuser.getPassword())) {
				
				//checking if admin admin is added
				if (password.equals("admin") && name.equalsIgnoreCase("admin")) {

					List<empBean> list = empDao.getAllEmployees();
					session.setAttribute("name", tina);
					// response.sendRedirect("actioncontroller?list="+list);
					// response.sendRedirect("actioncontroller");
					response.sendRedirect("home.jsp");
				} 
				//if no admin is there
				else {

					out.println("specific user logged in ");
					session.setAttribute("name", specificuser.getUsername());
					// response.sendRedirect("actioncontroller?list="+list);
					// response.sendRedirect("actioncontroller");
					// response.sendRedirect("home.jsp");
					response.sendRedirect("user.jsp");

				}

			}else
			{
				System.out.println("username or password mismatched  ");
				out.println("please enter correct username or password ");
				request.getRequestDispatcher("index.jsp").include(request, response);  
			}

		}

		if (action.equalsIgnoreCase("logout")) {

			System.out.println("logout page  is redirected");
			// session.setAttribute("name", null);
			session = request.getSession();
			session.invalidate();

			response.sendRedirect("index.jsp");

		}

		if (action.equalsIgnoreCase("edit")) {
			System.out.println("edit page  is redirected");
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			empBean eb = empDao.getEmployeeById(id);
			session.setAttribute("eb", eb);
			request.getRequestDispatcher("registration.jsp").include(request, response);

		}
		if (action.equalsIgnoreCase("update")) {
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
		if (action.equalsIgnoreCase("delete")) {
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

		}
		if (action.equalsIgnoreCase("register")) {

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
			request.getSession().invalidate();
			out.println("registration done successfully");
			request.getRequestDispatcher("index.jsp").include(request, response);

		}
	}
}
