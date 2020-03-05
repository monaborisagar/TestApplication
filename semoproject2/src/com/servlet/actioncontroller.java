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

	
}
