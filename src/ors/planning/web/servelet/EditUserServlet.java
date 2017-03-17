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
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/edituser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		
		String code = (String) request.getParameter("code");
		
		usuarios user = null;
		
		String errorString = null;
		
		 try {
		 user = DBUtils.findUsuario(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
		 
		 request.setAttribute("errorString", errorString);
	     request.setAttribute("user", user);
	 
	     RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/edituser.jsp");
	      dispatcher.forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
