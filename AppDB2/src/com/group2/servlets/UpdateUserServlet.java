package com.group2.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group2.DBAcesslayer.DbConnection;


/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String name=(String)session.getAttribute("userName");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		
		try{
				DbConnection db=new DbConnection();
				int x=db.updateValues(name,email,country);
				if(x>0)
				{
					response.sendRedirect("sucessfulUpdate.html");
				}
				else
				{
					response.sendRedirect("updatefailure.html");
				}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}

}
