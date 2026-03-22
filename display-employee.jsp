<%@page import="com.qsp.Employee_Management_System.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #8B0000, #ff4b2b);
    padding: 20px;
}

/* table container */
.table-container {
    width: 95%;
    margin: auto;
    background: rgba(255, 255, 255, 0.9);
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.3);
}

/* heading */
h1 {
    text-align: center;
    margin-bottom: 20px;
}

/* table styling */
table {
    width: 100%;
    border-collapse: collapse;
    text-align: center;
}

/* header */
th {
    background-color: black;
    color: white;
    padding: 10px;
}

/* rows */
td {
    padding: 8px;
    border-bottom: 1px solid #ddd;
}

/* zebra effect */
tr:nth-child(even) {
    background-color: #f2f2f2;
}

/* hover effect */
tr:hover {
    background-color: #ddd;
}

/* action buttons */
a {
    text-decoration: none;
    padding: 6px 10px;
    border-radius: 5px;
    color: white;
    font-size: 14px;
}

/* update button */
a[href*="update"] {
    background-color: green;
}

/* delete button */
a[href*="delete"] {
    background-color: red;
}

a:hover {
    opacity: 0.8;
}
</style>
</head>




<body>

<div class="table-container">

<h1>Employee Details</h1>

<%
List<Employee> e=(List<Employee>)request.getAttribute("employee");
%>

<table>
<tr>
<th>EmpId</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Age</th>
<th>Gender</th>
<th>Salary</th>
<th>Role</th>
<th>Address</th>
<th>Phone</th>
<th colspan="2">Action</th>
</tr>

<% for(Employee emp:e){ %>
<tr>
<td><%=emp.getEmpid() %></td>
<td><%=emp.getName() %></td>
<td><%=emp.getEmail() %></td>
<td><%=emp.getPassword() %></td>
<td><%=emp.getAge() %></td>
<td><%=emp.getGender() %></td>
<td><%=emp.getSalary() %></td>
<td><%=emp.getRole() %></td>
<td><%=emp.getAddress() %></td>
<td><%=emp.getPhone() %></td>

<td>
<a href="update-form.jsp?id=<%=emp.getEmpid() %>">Update</a>
</td>

<td>
<a href="delete?id=<%=emp.getEmpid() %>">Delete</a>
</td>

</tr>
<% } %>

</table>

</div>
<a href="Home.jsp">Home</a>

</body>
</html>