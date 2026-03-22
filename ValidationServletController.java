package com.qsp.Employee_Management_System.controller;

import java.io.IOException;

import com.qsp.Employee_Management_System.dao.EmployeeDao;
import com.qsp.Employee_Management_System.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/validation")
public class ValidationServletController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String currentEmail=req.getParameter("empEmail");
	String currentPassword=req.getParameter("empPassword");
	
	//System.out.println(currentEmail+"---"+  currentPassword);
	EmployeeDao dao=new EmployeeDao();
	
	Employee emp=dao.getEmployeeByEmailAndPassword(currentEmail, currentPassword);
	
	
	if(emp!=null) {
		
		HttpSession session=req.getSession();
		session.setAttribute("empName", emp.getName());
				
		resp.sendRedirect("Home.jsp");
	}
	
	else {
		resp.sendRedirect("registration-form.html");
	}
	
	
	
	
	}
}
