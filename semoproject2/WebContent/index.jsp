


<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

	response.setHeader("Pragma","no-cache");

	response.setHeader("Expires", "0"); 
%>

<%@include file="include/header.jsp" %>
       
        <main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
              <%
        if(request.getAttribute("success")!=null)
        {
        %>
        <p style="color: green;align-self: center;margin-left: 500px;">data saved sucessfully</p>
        <%
        }
        %>
                    <div class="card">
                   
                        <div class="card-header">Login</div>
                        <div class="card-body">
                            <form name="my-form"  method="POST" action="loginServlet" onsubmit="return validate12();">
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Username</label>
                                    <div class="col-md-6">
                                        <input type="text" id="username" class="form-control" name="username">
                                    </div>
                                </div>

                                 <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">password</label>
                                    <div class="col-md-6">
                                        <input type="text" id="password" class="form-control" name="password">
                                    </div>
                                </div>


                                

                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" name="action" value="login" class="btn btn-primary">
                                        login
                                        </button>
                                        <a href="registration.jsp" >registration</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
<script type="text/javascript">

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
	
</script>
</html>