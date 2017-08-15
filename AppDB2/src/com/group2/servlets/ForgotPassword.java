package com.group2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.DBAcesslayer.DbConnection;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username=request.getParameter("uname");
		String password1=request.getParameter("passwordf");
		String password2=request.getParameter("passwords");
		DbConnection db=new DbConnection();
		if(password1.equals(password2))
		{
		try
		{
			int x=db.forgotPassword(username, password1);
			if(x>0)
			{
				response.sendRedirect("forgotsucess.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
		
	}

}
