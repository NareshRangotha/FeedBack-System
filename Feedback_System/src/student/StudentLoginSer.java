package student;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.Crud_op;

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/StudentLoginSer")
public class StudentLoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginSer() {
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
		try
		{
			Crud_op.connect();
		ResultSet res = Crud_op.studentLogin(request.getParameter("txtuser"),request.getParameter("txtpass"));
		if(res.next())
		{
			HttpSession ses = request.getSession();
			ses.setAttribute("sessionsid",request.getParameter("txtuser"));
			response.sendRedirect("student/studentdash.jsp");
		}
		else
		{
			response.sendRedirect("student/studentlogin.jsp?q=invalid userid and password");
		}
		}
		catch(Exception ex)
		{
			
		}
	}

}
