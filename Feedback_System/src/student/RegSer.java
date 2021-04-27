package student;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.*;
/**
 * Servlet implementation class RegSer
 */
@WebServlet("/RegSer")
public class RegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegSer() {
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
		PrintWriter out = response.getWriter();
		try
		{
		Crud_op.connect();
		int res=Crud_op.studentRegInsert(request.getParameter("txtuser"),request.getParameter("txtpass"),request.getParameter("txtemail"),request.getParameter("txtmobile"));
		if(res!=0)
		{
			response.sendRedirect("student/studentlogin.jsp");
		}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}
}