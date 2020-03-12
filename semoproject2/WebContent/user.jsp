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
<div style=" border:thick solid #c7c7c7;margin-right: 300px;margin-bottom: 500px;margin-left: 400px;padding-bottom: 200px;margin-top:40px:
padding-top: 50px;padding-right: 100px;padding-left: 100px;overflow: scroll;height: 700px;">
<table class="table table-striped" style="width: 1000px;margin-top: 40px;">
  <!-- <thead>
    <tr>
      <th scope="col" style="width: 10%">#Sr no</th>
      <th scope="col"  style="width: 90%">First</th>
      
    </tr>
    
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td colspan="2">lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum </td>
      
    </tr>
    <tr>
      <th scope="row" style="width: 10%"></th>
      <td >gbgfbg</td>
       <td >gbgfbg</td>
    </tr>
   
    
  </tbody> -->
  
  <!-- <tr>
  <td>1</td>
    <td colspan="2" scope="row">The section contains questions and answers on the concepts of objects, method overriding, inheritance, abstract class and super.</td>
  </tr>
  <tr>
  <td></td>
    <td>A. Method Overriding</td>
    <td>B. Inheritance – Abstract Class and Super</td>
  </tr>
  <tr>
  <td></td>
    <td>C. Method Overriding</td>
    <td>D. Method Overriding</td>
  </tr>
   -->
  <tr>
  <td>Q1:</td>
    <td colspan="2" scope="row"> The section contains questions and answers on the concepts of objects, method overriding, inheritance, abstract class and super.</td>
  </tr>
  <tr>
  <td></td>
    <td>A. Method Overriding</td>
    <td>B. Inheritance – Abstract Class and Super</td>
  </tr>
  <tr>
  <td></td>
    <td>C. Method Overriding</td>
    <td>D. Method Overriding</td>
  </tr>
  
   
  
</table>

</div>







</body>
</html>