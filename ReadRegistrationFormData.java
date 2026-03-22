package com.qsp.Employee_Management_System.controller;

import java.io.IOException;

import com.qsp.Employee_Management_System.dao.EmployeeDao;
import com.qsp.Employee_Management_System.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ReadRegistrationFormData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empid=req.getParameter("empId");
		String name=req.getParameter("empName");
		String email=req.getParameter("empEmail");
		String password=req.getParameter("empPwd");
		String age=req.getParameter("empAge");
		String gender=req.getParameter("empGender");
		String salary=req.getParameter("empSalary");
		String role=req.getParameter("empRole");
		String address=req.getParameter("empAddress");
        String phone=req.getParameter("empPhone");
        
        //bind this data into employee object.
        
        Employee emp=new Employee();
        
        emp.setEmpid(Integer.parseInt(empid));
        emp.setName(name);
        emp.setEmail(email);
        emp.setPassword(password);
        emp.setAge(Integer.parseInt(age));
        emp.setGender(gender);
        emp.setSalary(Double.parseDouble(salary));
        emp.setRole(role);
        emp.setAddress(address);
        emp.setPhone(Long.parseLong(phone));
        
        //call save method from dao layer and pass the employee object
        EmployeeDao dao=new EmployeeDao();
        boolean b=dao.saveEmployee(emp);  
        
        
        if(b) {
        	System.out.println("Data is inserted....");
        	
        	resp.sendRedirect("Login.html");
        }
        else {
        	System.out.println("Data is not inserted...");
        }
        
        
        
        
        
	}
}
