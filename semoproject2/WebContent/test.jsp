<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

	response.setHeader("Pragma","no-cache");

	response.setHeader("Expires", "0"); 
	
	if(session.getAttribute("adminname")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>

<%@page import="com.bean.categoryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.categoryDao"%>
<%
List<categoryBean> list = (List<categoryBean>)categoryDao.getAllCategory();
%>


<%@include file="include/header.jsp"%>

<main class="my-form">
	<div class="cotainer">
		<div class="row justify-content-center">
			<div class="col-md-8">



				<div class="card">

					<div class="card-header">Add test</div>
					<div class="card-body">
					<form id="my-form" method="post" action="testServlet">
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right"> Test
									Name</label>
								<div class="col-md-6">
									<input type="text" id="testname" class="form-control"
										name="testname">
								</div>
							</div>

							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Category</label>
								<div class="col-md-6">
								<select  name="category" class="form-control">
								<%
								for(categoryBean e :list)
								{
								%>
								
										<option value="<%=e.getCategory_id()%>"><%=e.getCategory_name() %></option>
								<%
								}
								%>
								</select>
								
									<!-- <select  name="category" class="form-control">
										<option value="1">Java_Programing</option>
										<option value="2">.net_Programing</option>
										<option value="3">php</option>
										<option value="4">Admin</option>
										<option value="5">Python</option>
										<option value="6">.SEO</option>
										<option value="7">Angular</option>
										<option value="8">Web_Development</option>
									</select> -->
								</div>


								<!-- <tr><td>Select Course</td>
				<td><select  multiple name="courses" size=3 >
						<option  value="1">Java_Programing</option>
						<option value="2">.net_Programing</option>
						<option value="3">php</option>
						<option value="4">Admin</option>
						<option  value="5">Python</option>
						<option value="6">.SEO</option>
						<option value="7">Angular</option>
						<option value="8">Web_Development</option>
						
				</select></td>
			</tr> -->

							</div>
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Duration</label>
								<div class="col-md-6">
									<input type="text" id="test_duration" class="form-control"
										name="test_duration">
								</div>
							</div>

							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">TotalQuestions</label>
								<div class="col-md-6">
									<input type="text" id="total_questions" class="form-control"
										name="total_questions">
										
										<!-- <button id="btn1">Append question</button><br/> -->
										
										<span class="col-md-4 col-form-label text-md-right"></span>
								</div>
							</div>





							<div class="col-md-6 offset-md-4">
								<button type="submit" name="action" value="login" id="savetest"
									class="btn btn-primary" >SaveTest</button>
								<a href="home.jsp">back to homepage</a>
							</div>
					</div>
					</form>
					<button id="btn1" style=" width: 50%;margin-left: 60px">Append question</button><br/>
				</div>
			</div>
		</div>
	</div>
	</div>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
<!-- <script type="text/javascript">

	function validate12() {
		var username1 = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		
		if (username1 == "" || username1 == null) {
			alert("Please enter username");
			return false;
		}
		if (password == "" || password == null) {
			alert("Please enter password");
			return false;
		}
		
		   
	}
	
</script> -->
<script>
$(document).ready(function(){
 var i=0;
  $("#btn1").click(function(){
	  i++;
     $("span").append("question"+i+" :<input type=\"text\"  name=\"question"+i+"\"/><br/>");
    $("span").append("a:<input type=\"text\" name=\"a_answer_"+i+"\"/>b:<input type=\"text\" name=\"b_answer_"+i+"\"/><br/>c:<input type=\"text\" name=\"c_answer_"+i+"\"/>d:<input type=\"text\" name=\"d_answer_"+i+"\"/><br/>");
    $("span").append("correct answer for "+i+" :<input type=\"text\"  name=\"correctans_"+i+"\"/><br/>"); 
    
   
        $("#total_questions").val(i);
     
  });
  
 /*  $( "#savetest" ).click(function() {
	  $( "#my-form" ).attr("method", "POST");
	  $( "#my-form" ).attr("action", "loginservlet");
	  $( "#my-form" ).submit();
	  
	}); */
 
});
</script>
</html>
