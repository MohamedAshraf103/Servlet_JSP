package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.repos.UserRepo;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(email.equals("")||name.equals("")||password.equals(""))
		{
			response.sendRedirect("ErrorPage");
		}
		
		else {
			User user=new User(name,email,password);
			UserRepo.userSignUp(user);
			request.getRequestDispatcher("index.html").forward(request, response);
			
		}
	}

}
