package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud_op;
/**
 * Servlet implementation class UpdateSer
 */
@WebServlet("/UpdateSer")
public class UpdateSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSer() {
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
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		try
		{
			Crud_op.connect();
			int x = Crud_op.update(Integer.parseInt(request.getParameter("txtrno")),request.getParameter("txtsname"),request.getParameter("txtbranch"),Integer.parseInt(request.getParameter("txtfees")));
		    if(x!=0)
		    {
		    	//out.println("data updated successfully");
		    	response.sendRedirect("viewstudentinfo.jsp");
		    }
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
			
		}
	}

}
