<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Create Product</title>
 </head>
 <body>

    <h3>Create Users</h3>
    
    <p style="color: red;">${errorString}</p>
    
    <form method="POST" action="doeditUsers">
       <table border="0">
          <input type="hidden" name="identidad" value="${user.identidad}" />
          <tr>
             <td>nombre</td>
             <td><input type="text" name="nombre" value="${user.nombre}" /></td>
          </tr>
          <tr>
             <td>departarmento</td>
             <td><input type="text" name="departarmento" value="${user.departamento}" /></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 <a href="${pageContext.request.contextPath}/UsersList">Cancel</a>
             </td>
          </tr>
       </table>
    </form>
    
    
 </body>
</html>