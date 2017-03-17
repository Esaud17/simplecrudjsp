package org.planning.web.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.planning.web.beans.usuarios;

public class DBUtils {
	
	 public static List<usuarios> queryUsuarios(Connection conn) throws SQLException { 
		 String sql = "Select a.identidad, a.nombre, a.departamento from usuario a ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      ResultSet rs = pstm.executeQuery();
	      List<usuarios> list = new ArrayList<usuarios>();
	      while (rs.next()) {
	          String idnt = rs.getString("identidad");
	          String nomb = rs.getString("nombre");
	          String depto = rs.getString("departamento");
	          
	          usuarios user = new usuarios();
	          user.setIdentidad(idnt);
	          user.setNombre(nomb);
	          user.setDepartamento(depto);
	          
	          list.add(user);
	      }
	      return list;
	  }
	 
	 public static usuarios findUsuario(Connection conn, String code) throws SQLException {
	      String sql ="Select a.identidad, a.nombre, a.departamento from usuario a where a.identidad=? ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, code);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      while (rs.next()) {
	    	  String idnt = rs.getString("identidad");
	          String nomb = rs.getString("nombre");
	          String depto = rs.getString("departamento");
	          
	          usuarios user = new usuarios();
	          user.setIdentidad(idnt);
	          user.setNombre(nomb);
	          user.setDepartamento(depto);
	          
	          return user;
	      }
	      return null;
	      
	    }
	  
	 
		 public static void updateUsuario(Connection conn, usuarios user) throws SQLException {
		      String sql = "Update usuario set nombre =?, departamento=? where identidad=? ";
		 
		      PreparedStatement pstm = conn.prepareStatement(sql);
		 
		      pstm.setString(1, user.getNombre());
		      pstm.setString(2, user.getDepartamento());
		      pstm.setString(3, user.getIdentidad());
		      pstm.executeUpdate();
		  }
		 
		  public static void insertUsuario(Connection conn, usuarios user) throws SQLException {
		      String sql = "Insert into usuario(nombre,departamento,identidad) values (?,?,?)";
		 
		      PreparedStatement pstm = conn.prepareStatement(sql);
		 
		      pstm.setString(1, user.getNombre());
		      pstm.setString(2, user.getDepartamento());
		      pstm.setString(3, user.getIdentidad());
		 
		      pstm.executeUpdate();
		  }
		 
		  public static void deleteUsuario(Connection conn, String idnt) throws SQLException {
		      String sql = "Delete from usuario where identidad= ?";
		 
		      PreparedStatement pstm = conn.prepareStatement(sql);
		 
		      pstm.setString(1, idnt);
		 
		      pstm.executeUpdate();
		  }
	 

}
