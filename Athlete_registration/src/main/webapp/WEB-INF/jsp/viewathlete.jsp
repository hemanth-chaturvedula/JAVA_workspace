   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Athletes List</h1>  
<table>  
<tr><th>Athlete_Id</th><th>Athlete_name</th><th>Athlete_gender</th><th>Category</th><th>Athlete_email</th><th>Athlete_Mobile_number</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="ath" items="${list}">   
   <tr>  
   <td>${ath.id}</td>
   <td>${ath.gender}</td>  
   <td>${ath.salary}</td>  
   <td>${ath.category}</td>
   <td>${ath.email}</td>
   <td>${ath.mobile_number}</td>  
   <td><a href="editathlete/${ath.id}">Edit</a></td>  
   <td><a href="deleteathlete/${ath.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>