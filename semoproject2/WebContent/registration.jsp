<%@include file="include/header.jsp"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setHeader("Expires", "0"); 
String a = (String)request.getAttribute("alert");

%>




<%
        
         empBean e = (empBean)session.getAttribute("eb");
           
       
     %>



<%
						   if(e==null)
						   {
						     %>
<main class="my-form">
	<div class="cotainer">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">Register</div>
					<div class="card-body">
						<form name="myForm" onsubmit="return validate()" method="POST"
							action="RegistrationServlet">
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Username</label>
								<div class="col-md-6">
									<input type="text" id="username" class="form-control"
										name="username" required="required">
								</div>
							</div>

							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">password</label>
								<div class="col-md-6">
									<input type="text" id="password" class="form-control"
										name="password" required="required">
								</div>
							</div>

							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">email</label>
								<div class="col-md-6">
									<input type="email" id="email" class="form-control"
										name="email" required="required">
								</div>
							</div>

							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">date</label>
								<div class="col-md-6">
									<input type="text" id="date" class="form-control" name="date"
										required="required">
								</div>
							</div>

							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">phnenumber</label>
								<div class="col-md-6">
									<input type="text" id="phnenumber" class="form-control"
										name="phnenumber" required="required">
								</div>
							</div>


							<div class="col-md-6 offset-md-4">
								<button type="submit" name="action" value="Register"
									class="btn btn-primary">Register</button>
								<a href="index.jsp">back to login</a>
							</div>
					</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	</div>
	<%} %>


	<%
                             if(e!=null)
						   {
						     %>
	<main class="my-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Update</div>
						<div class="card-body">
							<form name="myForm" onsubmit="return validate()" method="POST"
								action="updateServlet">
								<div>
									Update page for
									<%=e.getUsername() %></div>
								<div class="form-group row">
									<!-- <label for="full_name" class="col-md-4 col-form-label text-md-right">id</label> -->
									<div class="col-md-6">
										<input type="hiddden" id="id" class="form-control" name="id"
											value="<%=e.getId() %>">
									</div>
								</div>
								<div class="form-group row">
									<label for="full_name"
										class="col-md-4 col-form-label text-md-right">Username</label>
									<div class="col-md-6">
										<input type="text" id="username" class="form-control"
											name="username" value="<%=e.getUsername() %>">
									</div>
								</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">password</label>
									<div class="col-md-6">
										<input type="text" id="password" class="form-control"
											name="password" value="<%=e.getPassword() %>">
									</div>
								</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">email</label>
									<div class="col-md-6">
										<input type="text" id="email" class="form-control"
											name="email" value="<%=e.getEmail() %>">
									</div>
								</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">date</label>
									<div class="col-md-6">
										<input type="text" id="date" class="form-control" name="date"
											value="<%=e.getDate() %>">
									</div>
								</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">phnenumber</label>
									<div class="col-md-6">
										<input type="text" id="phnenumber" class="form-control"
											name="phnenumber" value="<%=e.getPhnenumber() %>">
									</div>
								</div>


								<div class="col-md-6 offset-md-4">
									<button type="submit" name="action" value="update"
										class="btn btn-primary">update</button>
									<a href="home.jsp">back to homepage</a>


								</div>
						</div>
						</form>
						<input type="button" name="action" value="reset"
							onclick="reset();">
					</div>

				</div>
			</div>
		</div>
	</div>
	<%} %>


</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script type="text/javascript">
function reset()
  {
	alert("inside resdet");
	 document.getElementById("username").value='';
	 document.getElementById("password").value='';
	 document.getElementById("email").value='';
	 document.getElementById("date").value='';
	 document.getElementById("phnenumber").value='';
	
	}
	function validate() {
		var username1 = document.getElementById("username").value;

		if (username1 == "" || username1 == null) {
			alert("Please enter username");
			return false;
		}

		var phnenumber = document.getElementById("phnenumber").value;

		//alert(phnenumber.length);
		var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
		/* if (!(phoneno).test(phnenumber)) {
			
		
			alert("phnenumber pattern is not matched ");
			return false;
		} */
		
		 
		    var dob =document.getElementById("date").value;
		 //   alert("fdbdfb");
		    var pattern = /^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;
		  //  alert(dob);
		    
		    if ( !pattern.test(dob)) {
		    	
		        alert("Invalid date of birth\n");
		        return false;
		    }
		
		   
	}
	
</script>





</body>

</html>


