package com.qsp.Employee_Management_System.controller;

import java.io.IOException;

import com.qsp.Employee_Management_System.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteEmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		//System.out.println(id);
		EmployeeDao dao=new EmployeeDao();
		
		boolean b=dao.deleteEmployeeById(Integer.parseInt(id));
		
		if(b) {
			System.out.println("data is deleted");
			resp.sendRedirect("read");
		}
		else {
			System.out.println("given id is not found");
		}
		
	}
}
