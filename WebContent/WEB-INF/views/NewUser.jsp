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
    
    <form method="POST" action="doCreateUsers">
       <table border="0">
          <tr>
             <td>identidad</td>
             <td><input type="text" name="identidad" value="${user.identidad}" /></td>
          </tr>
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
                 <a href="UsersList">Cancel</a>
             </td>
          </tr>
       </table>
    </form>
    
    
 </body>
</html>