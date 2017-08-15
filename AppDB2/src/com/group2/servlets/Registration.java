package com.group2.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group2.DBAcesslayer.DbConnection;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		String password=request.getParameter("password");
					
		try
		{
				DbConnection db=new DbConnection();
				int x=db.registrationInsert(username,email,country,password);
		
		if(x>0)
		{
			response.sendRedirect("login.html");
		}
		else
		{
			response.sendRedirect("registrationfailure.html");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		
	}

}
