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
    background: linear-gradient(to right, brown, darkred);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* container */
.container {
    background-color: lightblue;
    padding: 40px;          /* more inner space */
    border-radius: 15px;
    text-align: center;
    box-shadow: 4px 4px 10px gray;

    width: 500px;           /* increased width */
    min-height: 320px;      /* increased height */
}

/* heading */
h1 {
    margin-bottom: 20px;
}

/* buttons (links) */
.menu a {
    display: block;
    margin: 10px 0;
    padding: 10px;
    text-decoration: none;
    background-color: black;
    color: white;
    border-radius: 5px;
    transition: 0.3s;
}

.menu a:hover {
    background-color: green;
}

/* error message */
.error {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    text-align: center;
}
</style>
</head>
<body>

<%
String name = (String) session.getAttribute("empName");
%>

<% if(name != null){ %>

<div class="container">

<h1>Welcome, <%= name %> 👋</h1>

<div class="menu">
    <a href="registration-form.html">Add Employee</a>
    <a href="read">View Employee</a>
    <a href="logout">Logout</a>
</div>

</div>

<% } else { %>

<div class="error">
<h1>⚠ Without login you cannot access this page</h1>
<a href="Login.html">Login Again</a>
</div>

<% } %>

</body>
</html>