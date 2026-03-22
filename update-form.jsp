<%@page import="com.qsp.Employee_Management_System.entity.Employee"%>
<%@page import="com.qsp.Employee_Management_System.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    background-color: brown;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

/* container */
.container {
    background-color: lightblue;
    width: 420px;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 3px 3px 5px grey;
    text-align: center;
}

/* heading */
h1 {
    margin-bottom: 15px;
}

/* form rows */
.form-group {
    display: flex;
    align-items: center;
    margin: 8px 0;
}

/* labels */
.form-group label {
    width: 120px;
    font-weight: bold;
}

/* inputs */
.form-group input {
    flex: 1;
    height: 25px;
    border-radius: 5px;
    border: 1px solid gray;
    padding: 5px;
}

/* gender */
.gender input {
    margin-left: 10px;
}

/* button */
.btn {
    text-align: center;
    margin-top: 10px;
}

.btn input {
    height: 35px;
    width: 120px;
    border-radius: 5px;
    border: none;
    background-color: black;
    color: white;
    cursor: pointer;
}

.btn input:hover {
    background-color: green;
}
</style>
</head>





<body>

<%
String id=request.getParameter("id");
EmployeeDao dao=new EmployeeDao();
Employee emp=dao.getEmployeeById(Integer.parseInt(id));
%>

<div class="container">

<h1>Employee Update</h1>

<form action="update-employee" method="post">

<div class="form-group">
<label>EmpId:</label>
<input type="text" name="empId" value="<%=emp.getEmpid()%>" readonly/>
</div>

<div class="form-group">
<label>Name:</label>
<input type="text" name="empName" value="<%=emp.getName()%>"/>
</div>

<div class="form-group">
<label>Email:</label>
<input type="email" name="empEmail" value="<%=emp.getEmail()%>"/>
</div>

<div class="form-group">
<label>Password:</label>
<input type="password" name="empPwd" value="<%=emp.getPassword()%>"/>
</div>

<div class="form-group">
<label>Age:</label>
<input type="text" name="empAge" value="<%=emp.getAge()%>"/>
</div>

<div class="form-group gender">
<label>Gender:</label>
<input type="radio" name="empGender" value="male"/> Male
<input type="radio" name="empGender" value="female"/> Female
</div>

<div class="form-group">
<label>Salary:</label>
<input type="text" name="empSalary" value="<%=emp.getSalary()%>"/>
</div>

<div class="form-group">
<label>Role:</label>
<input type="text" name="empRole" value="<%=emp.getRole()%>"/>
</div>

<div class="form-group">
<label>Address:</label>
<input type="text" name="empAddress" value="<%=emp.getAddress()%>"/>
</div>

<div class="form-group">
<label>Phone:</label>
<input type="text" name="empPhone" value="<%=emp.getPhone()%>"/>
</div>

<div class="btn">
<input type="submit" value="Update"/>
</div>

</form>

</div>

</body>
</html>