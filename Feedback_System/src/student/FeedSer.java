package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.*;
/**
 * Servlet implementation class FeedSer
 */
@WebServlet("/FeedSer")
public class FeedSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedSer() {
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
		HttpSession sess = request.getSession();
		String s = (String)sess.getAttribute("sessionsid");
		if(!Crud_op.checkfeed(request.getParameter("txtfname"), s))
		{
		int res = Crud_op.FeedInsert(request.getParameter("txtfname"), s,request.getParameter("rating"));
		if(res!=0)
		{
			response.sendRedirect("student/studentdash.jsp?q=feedback submitted");
		}
		}
		else
		{
			response.sendRedirect("student/studentdash.jsp?q=feedback already submitted");
		}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
