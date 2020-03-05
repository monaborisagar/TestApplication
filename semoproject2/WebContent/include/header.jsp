<%@page import="com.bean.empBean"%>
<%@page import="com.dao.empDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
  <link href="css/style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
    <div class="container">
    <a class="navbar-brand" href="#">TestProject</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
           <!--  <li class="nav-item">
                <a class="nav-link" href="#">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Register</a>
            </li> -->
            <%
            if(session.getAttribute("adminname")!=null||(session.getAttribute("username")!=null))
            {
            %>
             <li class="nav-item">
	             <form name="action" method="POST" action="logoutServlet">
	                <a class="nav-link" href="#"> <input type="submit" name="action" value="logout"/></a>
	             </form>
            </li>
          
            <%} else{%>
           		  <li class="nav-item">
            
                <a class="nav-link" href="index.jsp"> <input type="submit" name="action" value="login"/></a>
                
            </li>
            <%} %>
        </ul>

    </div>
    </div>
</nav>