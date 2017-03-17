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
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			Connection conn = MyUtils.getStoredConnection(request);
		
			String idnt = (String) request.getParameter("code");
		
			String errorString = null;
			
			 try {
				DBUtils.deleteUsuario(conn, idnt);
		        } catch (SQLException e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		      }
			 
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
