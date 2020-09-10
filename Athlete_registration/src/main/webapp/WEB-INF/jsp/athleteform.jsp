<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <!--Have to validate the inputs and make a list to choose from for the characters  -->
        <h1>New Athlete Registration</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>
         <tr>    
          <td>Gender : </td>   
          <td><form:input path="gender"  /></td>  
         </tr>
         <tr>    
          <td>Category : </td>   
          <td><td><!-- form:input path="category"  /-->
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
          <td><form:input path="mobile_number"  /></td>  
         </tr>
         <tr>
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form> 