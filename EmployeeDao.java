package com.qsp.Employee_Management_System.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.Employee_Management_System.connection.GetConnection;
import com.qsp.Employee_Management_System.entity.Employee;

public class EmployeeDao {

	Connection con=GetConnection.getConnectionObject();
	
	//design a method to save data into database
	public boolean saveEmployee(Employee emp) {
		
		
		String insertQuery="insert into employee values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm=con.prepareStatement(insertQuery); 
			
			pstm.setInt(1, emp.getEmpid());
			pstm.setString(2,emp.getName());
			pstm.setString(3,emp.getEmail());
			pstm.setString(4,emp.getPassword());
			pstm.setInt(5,emp.getAge());
			pstm.setString(6,emp.getGender());
			pstm.setDouble(7, emp.getSalary());
			pstm.setString(8, emp.getRole());
			pstm.setString(9,emp.getAddress());
			pstm.setLong(10, emp.getPhone());
			
			return pstm.executeUpdate()>0;
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	/*
	 * design a method to return list of employee
	 */
	
	
	public List<Employee> getAllEmployee(){
		
		String selectQuery="select * from employee";
		
		List<Employee> emp= new ArrayList<Employee>();
		
		try {
			PreparedStatement pstm=con.prepareStatement(selectQuery);
			ResultSet res=pstm.executeQuery();
			
			
			while(res.next()) {
				int empid=res.getInt("empid");
				String name=res.getString("name");
				String email=res.getString("email");
				String pwd=res.getString("password");
				int age=res.getInt("age");
				String gender=res.getString("gender");
				double sal=res.getDouble("salary");
				String role=res.getString("role");
				String address=res.getString("address");
				long phone=res.getLong("phone");
				
				//bind all data into object
				
				Employee employee=new Employee();
				
				employee.setEmpid(empid);
				employee.setName(name);
				employee.setEmail(email);
				employee.setPassword(pwd);;
				employee.setAge(age);
				employee.setGender(gender);
				employee.setSalary(sal);
				employee.setRole(role);
				employee.setAddress(address);
				employee.setPhone(phone);
				
				//add object into list
				emp.add(employee);
				
			}
			
		}
		catch(Exception e) {
			
		}
		return emp;
		
	}
	
	/*
	 * design a method to delete record
	 */
	public boolean deleteEmployeeById(int id) {
		String deleteQuery="delete from employee where empid=?";
		
		try {
			PreparedStatement pstm=con.prepareStatement(deleteQuery);
			pstm.setInt(1, id);
			int row=pstm.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	
	/*
	 * 
	 * design a method to fetch record based on id
	 */
	

	public Employee getEmployeeById(int id){
		
		String selectQuery="select * from employee where empid=?";
		
		
		
		try {
			PreparedStatement pstm=con.prepareStatement(selectQuery);
			pstm.setInt(1,id );
			ResultSet res=pstm.executeQuery();
			
			
			    if(res.next()) {
				int empid=res.getInt("empid");
				String name=res.getString("name");
				String email=res.getString("email");
				String pwd=res.getString("password");
				int age=res.getInt("age");
				String gender=res.getString("gender");
				double sal=res.getDouble("salary");
				String role=res.getString("role");
				String address=res.getString("address");
				long phone=res.getLong("phone");
				
				//bind all data into object
				
				Employee employee=new Employee();
				
				employee.setEmpid(empid);
				employee.setName(name);
				employee.setEmail(email);
				employee.setPassword(address);
				employee.setAge(age);
				employee.setGender(gender);
				employee.setSalary(sal);
				employee.setRole(role);
				employee.setAddress(address);
				employee.setPhone(phone);
				
				return employee;
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//design a method to update
	 public boolean updateEmployee(Employee emp) {
		 String updateQuery="update employee set name=?,email=?,password=?, age=?,gender=?,salary=?,role=?,address=?,phone=? where empid=?" ;
		 try {
			PreparedStatement pstm= con.prepareStatement(updateQuery);
			pstm.setString(1,emp.getName());
			pstm.setString(2, emp.getEmail());
			pstm.setString(3, emp.getPassword());
			pstm.setInt(4, emp.getAge());
			pstm.setString(5, emp.getGender());
			pstm.setDouble(6, emp.getSalary());
			pstm.setString(7, emp.getRole());
			pstm.setString(8,emp.getAddress());
			pstm.setLong(9, emp.getPhone());
			pstm.setInt(10, emp.getEmpid());
			
			return pstm.executeUpdate()>0;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return false;
	 }
	
	 
	 
	 /*
	  * design a method to fetch employee based on email and password
	  * 
	  */
	 
	 
	 public Employee getEmployeeByEmailAndPassword(String currentEmail, String curentPassword){
			
			String selectQuery="select * from employee where email=? and password=?";
			
			
			
			try {
				PreparedStatement pstm=con.prepareStatement(selectQuery);
				
				pstm.setString(1, currentEmail);
				pstm.setString(2, curentPassword);
				
				ResultSet res=pstm.executeQuery();
				
				
				    if(res.next()) {
					int empid=res.getInt("empid");
					String name=res.getString("name");
					String email=res.getString("email");
					String pwd=res.getString("password");
					int age=res.getInt("age");
					String gender=res.getString("gender");
					double sal=res.getDouble("salary");
					String role=res.getString("role");
					String address=res.getString("address");
					long phone=res.getLong("phone");
					
					//bind all data into object
					
					Employee employee=new Employee();
					
					employee.setEmpid(empid);
					employee.setName(name);
					employee.setEmail(email);
					employee.setPassword(address);
					employee.setAge(age);
					employee.setGender(gender);
					employee.setSalary(sal);
					employee.setRole(role);
					employee.setAddress(address);
					employee.setPhone(phone);
					
					return employee;
					
					
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
	 
	
	
	
	
	
	
	
	
}
