package ors.planning.web.servelet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.planning.web.beans.usuarios;
import org.planning.web.utils.DBUtils;
import org.planning.web.utils.MyUtils;

/**
 * Servlet implementation class DoCreateUsersServlet
 */
@WebServlet("/doCreateUsers")
public class DoCreateUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 	Connection conn = MyUtils.getStoredConnection(request);
		 
	       String ident = (String) request.getParameter("identidad");
	       String name = (String) request.getParameter("nombre");
	       String depto = (String) request.getParameter("departarmento");
	       
	       usuarios user = new usuarios();
	       user.setNombre(name);
	       user.setIdentidad(ident);
	       user.setDepartamento(depto);
	       
	       String errorString = null;
	       
	       try {
               DBUtils.insertUsuario(conn, user);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
	       
	       request.setAttribute("errorString", errorString);
	       request.setAttribute("user", user);
	       
	       response.sendRedirect(request.getContextPath() + "/UsersList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
