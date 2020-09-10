<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Athlete</h1>
       <form:form method="POST" action="/Athlete_registration/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
        <tr>    
          <td>Gender : </td>   
          <td><!--  <form:input path="gender"/>-->  
        	Male <form:radiobutton path="gender" value="Male"/>  
        	Female <form:radiobutton path="gender" value="Female"/>  
          </td>  
         </tr>
         <tr>    
          <td>Category : </td>   
          <td><!-- form:input path="category"  /-->
         	<form:select path="category">  
        	<form:option value="Javelin throw" label="Javelin throw"/>  
        	<form:option value="Shot put" label="Shot put"/>  
        	<form:option value="Sprint" label="Sprint"/>  
        	<form:option value="Long distance" label="Long distance"/>  
        	</form:select> 
          </td>  
         </tr>
         <tr>    
          <td>E-mail : </td>   
          <td><form:input path="email"  /></td>  
         </tr>
         <tr>    
          <td>Mobile Number : </td>   
          <td><form:input path="mobile_number"/></td>  
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form> 