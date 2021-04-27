package admin;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.*;

/**
 * Servlet implementation class AdminLoginSer
 */
@WebServlet("/AdminLoginSer")
public class AdminLoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		Crud_op.connect();
		ResultSet res = Crud_op.adminLogin(request.getParameter("txtuser"),request.getParameter("txtpass"));
		if(res.next())
		{
			HttpSession ses = request.getSession();
			ses.setAttribute("sessionaid",request.getParameter("txtuser"));
			response.sendRedirect("admin/viewstudentinfo.jsp");
		}
		else
		{
			response.sendRedirect("admin/AdminLoginSer.jsp?q=invalid userid and password");
		}
		}
		catch(Exception ex)
		{
			
		}
	}
}


