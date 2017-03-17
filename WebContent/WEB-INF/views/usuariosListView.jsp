<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Usuarios List</title>
 </head>
 <body>

    <h3>Usuarios List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Identidad</th>
          <th>Nombre</th>
          <th>Departamento</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${usersList}" var="user" >
          <tr>
             <td>${user.identidad}</td>
             <td>${user.nombre}</td>
             <td>${user.departamento}</td>
             <td>
                <a href="edituser?code=${user.identidad}">Edit</a>
             </td>
             <td>
                <a href="deleteUser?code=${user.identidad}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="CreateUsers" >Create User</a>
 
 
 </body>
</html>