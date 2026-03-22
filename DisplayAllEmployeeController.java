package com.qsp.Employee_Management_System.controller;

import java.io.IOException;
import java.util.List;

import com.qsp.Employee_Management_System.dao.EmployeeDao;
import com.qsp.Employee_Management_System.entity.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class DisplayAllEmployeeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeDao dao=new EmployeeDao();
		List<Employee> emp=dao.getAllEmployee();
		
		req.setAttribute("employee", emp);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display-employee.jsp");
		
		dispatcher.forward(req, resp);
		}
	}


