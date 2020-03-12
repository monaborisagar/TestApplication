<%@page import="java.util.List"%>
<%@include file="include/header.jsp"%>
<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

	response.setHeader("Pragma","no-cache");

	response.setHeader("Expires", "0"); 
//session.getAttribute("name");

if(session.getAttribute("adminname")==null)
{
    response.sendRedirect("index.jsp");
}else{
	
	String mona = (String)session.getAttribute("adminname");	
}
	
%>


<h1>hello ${adminname}</h1>
<%
out.println(session.getId());
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



<main class="my-form">
	<div class="cotainer">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">Register</div>
					<div class="card-body">
						
							<table border='1' width='100%'>
								<tr>

									<th>sr no</th>
									<th>ID</th>
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
					 m=i+m;
		     			;
			%>
								<tr>

									<td><%=m %></td>


									<td><%=e.getId() %></td>
									<td><%=e.getUsername()%></td>
									<td><%=e.getPassword()%></td>
									<td><%=e.getEmail()%></td>
									<td><%=e.getDate()%></td>
									<td><%=e.getPhnenumber() %></td>

									<td>
										<form name="edit" method="post" action="EditServlet">
											<input type="hidden" name="id" value="<%=e.getId()%>" /> <input
												type="submit" id="edit" name="action" value="edit" />
										</form>
									</td>


									<td>
										<form name="delete" method="post" action="DeleteServlet">
											<input type="hidden" name="id" value="<%=e.getId()%>">
											<input type="submit" id="delete" name="action" value="delete" />
										</form>
									</td>

								</tr>

								<%} %>

							</table>
						<a href="test.jsp">create test</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</main>



<!-- <form name="action" method="POST" action="logoutServlet">
	<input type="submit" name="action" value="logout" />
</form> -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>