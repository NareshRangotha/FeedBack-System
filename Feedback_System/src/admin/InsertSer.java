package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.*;
/**
 * Servlet implementation class StudentSer
 */
@WebServlet("/InsertSer")
public class InsertSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSer() {
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
		PrintWriter out = response.getWriter();
		try
		{
			Crud_op.connect();
			int res=Crud_op.insert(Integer.parseInt(request.getParameter("txtrno")), request.getParameter("txtname"), request.getParameter("txtbranch"),Integer.parseInt(request.getParameter("txtfees")));
		    Crud_op.closeConn();
		    String s = "";
		    if(res==1)
		    {
		    	s= "data inserted successfully";
		    }
		    else
		    {
		    	s = "data not inserted successfully";
		    }
		    response.sendRedirect("admin/viewstudentinfo.jsp?q="+s);
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
