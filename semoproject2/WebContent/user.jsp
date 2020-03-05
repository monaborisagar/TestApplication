<%@include file="include/header.jsp" %>
<%

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setHeader("Expires", "0"); 
if(session.getAttribute("username")==null)
{
	response.sendRedirect("index.jsp");
}

%>

<div style="margin-left: 100px;color: blue;margin-top: 50px;">Hello ${username},Welcome to Profile page</div>
</body>
</html>