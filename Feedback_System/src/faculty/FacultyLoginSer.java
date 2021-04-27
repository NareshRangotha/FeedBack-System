package faculty;

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
 * Servlet implementation class FacultyLoginSer
 */
@WebServlet("/FacultyLoginSer")
public class FacultyLoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyLoginSer() {
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
		ResultSet res = Crud_op.facultyLogin(request.getParameter("txtuser"),request.getParameter("txtpass"));
		if(res.next())
		{
			HttpSession ses = request.getSession();
			ses.setAttribute("sessionfid",request.getParameter("txtuser"));
			response.sendRedirect("faculty/facultydash.jsp");
		}
		else
		{
			response.sendRedirect("faculty/facultylogin.jsp?q=invalid userid and password");
		}
		}
		catch(Exception ex)
		{
			
		}
	}

}
