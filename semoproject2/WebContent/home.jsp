<%@page import="com.dao.empDao"%>
<%@page import="com.bean.empBean"%>

<%@page import="java.util.List"%>
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

<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

	response.setHeader("Pragma","no-cache");

	response.setHeader("Expires", "0"); 
//session.getAttribute("name");
out.print(session.getAttribute("name"));
if(session.getAttribute("name")==null)
{
    response.sendRedirect("actioncontroller");
}else{
	
	String mona = (String)session.getAttribute("name");	
}
	
%>


<h1>hello ${name}</h1>
<%
List<empBean> list = empDao.getAllEmployees();
%>
<%String p= (String)request.getAttribute("deletemessage");
if(p!=null)
{
%>
<div class="hideone"><%=p %></div>

<%	
}
%>
<%@include file="include/header.jsp" %>

	<%-- <form name="myForm" action="ActionController"
		onsubmit="return validate()" method="post">

		<table border='1' width='100%'>
			<tr>
				<th>sr no</th>
				<th>username</th>
				<th>password</th>
				<th>email</th>
				<th>date</th>
				<th>phnenumber</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
			   int m=0;int i=1;
				for (empBean e : list) {
			%>
			<tr>
			 <%
			 
			  m=i+m;
     			;
			 %>
			    <td><%=m %></td>
			    
			 
				<td><%=e.getId() %></td>
				<td><%=e.getUsername()%></td>
				<td><%=e.getPassword()%></td>
				<td><%=e.getEmail()%></td>
				<td><%=e.getDate()%></td>
				<td><%=e.getPhnenumber() %></td>

				<td>
					<form name="edit" method="post" action="actioncontroller">
						<input type="hidden" name="id" value="<%=e.getId() %>"/> <input
							type="submit" name="action" value="edit"/>
					</form>
				</td>
				
				
				<td>
					<form name="delete" method="post" action="actioncontroller">
					<input type="hidden" name="id" value="<%=e.getId()%>">
						<input type="submit"  id="delete" name="action" value="delete" />
					</form>
				</td>

			</tr>
			
			<%} %>

		</table>

	</form>
 --%>
 

<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Register</div>
                        <div class="card-body">
                            <form  name="myForm" action="ActionController" onsubmit="return validate()" method="post">
                               <table border='1' width='100%'>
			<tr>
				<th>sr no</th>
				<th>username</th>
				<th>password</th>
				<th>email</th>
				<th>date</th>
				<th>phnenumber</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
			   int m=0;int i=1;
				for (empBean e : list) {
			%>
			<tr>
			 <%
			 
			  m=i+m;
     			;
			 %>
			    <td><%=m %></td>
			    
			 
				<%-- <td><%=e.getId() %></td> --%>
				<td><%=e.getUsername()%></td>
				<td><%=e.getPassword()%></td>
				<td><%=e.getEmail()%></td>
				<td><%=e.getDate()%></td>
				<td><%=e.getPhnenumber() %></td>

				<td>
					<form name="edit" method="post" action="actioncontroller">
						<input type="hidden" name="id" value="<%=e.getId() %>"/> <input
							type="submit" name="action" value="edit"/>
					</form>
				</td>
				
				
				<td>
					<form name="delete" method="post" action="actioncontroller">
					<input type="hidden" name="id" value="<%=e.getId()%>">
						<input type="submit"  id="delete" name="action" value="delete" />
					</form>
				</td>

			</tr>
			
			<%} %>

		</table>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>

</main>
 
 
 
<form name="action" method="POST" action="actioncontroller">
 <input type="submit" name="action" value="logout"/>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>