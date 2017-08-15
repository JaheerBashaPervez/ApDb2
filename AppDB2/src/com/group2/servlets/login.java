package com.group2.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group2.DBAcesslayer.DbConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String password=request.getParameter("password");
		boolean flag=true;
		HttpSession session = request.getSession();
		session.setAttribute("userName", username);
		try
		{
			DbConnection db=new DbConnection();
			flag=db.loginAuthentication(username, password);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(flag)
		{
			response.sendRedirect("UpdateUser.html");
		}
		else
		{
			response.sendRedirect("errorlogin.html");
		}
		
			
	}

}
