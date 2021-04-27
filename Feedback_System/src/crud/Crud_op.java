package crud;


import java.util.Scanner;

import java.sql.*;

public class Crud_op 
{
	
	   private int rno;
	   private String sname;
	   private String branch;
	   private int fees;
	   static Statement st;
	   static Connection conn;
	   public static void connect() throws ClassNotFoundException,SQLException
	   {
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_system","root","");
		   st = conn.createStatement();
	   }
	   
	   public static int insert(int rno,String sname,String branch, int fees) throws SQLException
	   {
		   int res=st.executeUpdate("insert into student(rno,sname,branch,fees) values('"+rno+"','"+sname+"','"+branch+"','"+fees+"')");
	       return res;
	   }
	   public static int fInsert(int fid,String fname,String branch, int sub) throws SQLException
	   {
		   int res=st.executeUpdate("insert into faculty(fid,fname,branch,sub) values('"+fid+"','"+fname+"','"+branch+"','"+sub+"')");
	       return res;
	   }
	   public static int studentRegInsert(String uid,String upass,String email, String mobile) throws SQLException
	   {
		   int res=st.executeUpdate("insert into registration(username,password,email,mobileno) values('"+uid+"','"+upass+"','"+email+"','"+mobile+"')");
	       return res;
	   }
	   public static int facultyRegInsert(String fid,String fpass,String email, String mobile) throws SQLException
	   {
		   int res=st.executeUpdate("insert into facultyreg(fname,password,email,mobileno) values('"+fid+"','"+fpass+"','"+email+"','"+mobile+"')");
	       return res;
	   }
	   public static boolean checkfeed(String fname,String fto) throws SQLException
	   {
		   ResultSet res=st.executeQuery("select * from feed  where facultyname='"+fname+"' and feedto='"+fto+"'");
	       return res.next();
	       
	   
	   }
	   public static int FeedInsert(String fname,String fto, String rt) throws SQLException
	   {
		   int res=st.executeUpdate("insert into feed(facultyname,feedto,rating) values('"+fname+"','"+fto+"','"+rt+"')");
	       return res;
	       
	   
	   }
	   public static ResultSet studentLogin(String sid,String pass) throws SQLException
	   {	
		   ResultSet res = st.executeQuery("select * from registration where username='"+sid+"' and password='"+pass+"'");
		   return res;
	   }
	   public static ResultSet facultyLogin(String fid,String pass) throws SQLException
	   {	
		   ResultSet res = st.executeQuery("select * from facultyreg where username='"+fid+"' and password='"+pass+"'");
		   return res;
	   }
	   public static ResultSet adminLogin(String username,String pass) throws SQLException
	   {	
		   ResultSet res = st.executeQuery("select * from admin where userid='"+username+"' and password='"+pass+"'");
		   return res;
	   }
	   public static int update(int rno,String sname,String branch, int fees) throws SQLException
	   {
		   int res=st.executeUpdate("update student set sname='"+sname+"',branch='"+branch+"',fees='"+fees+"' where rno='"+rno+"'");
	       return res;
	   
	   
	   }
	   
	   
	   public static int delete(int rno) throws SQLException
	   {
		   int res=st.executeUpdate("delete from student where rno='"+rno+"'");
	       return res;
	   
	   
	   }
	   
	   public static 	ResultSet showdata() throws SQLException
	   {	
		   ResultSet res = st.executeQuery("select * from student");
		   return res;
	   }
	   public static 	ResultSet fshowdata() throws SQLException
	   {	
		   ResultSet res = st.executeQuery("select * from facultyreg");
		   return res;
	   }
	   public static ResultSet showfeedback() throws SQLException
	   {	
		   ResultSet res = st.executeQuery("select * from feed");
		   return res;
	   }
	   
	   
	   public static ResultSet findData(int r) throws SQLException
	   {
		   ResultSet res = st.executeQuery("select * from student where rno='"+r+"'");
		   return res;
	   }
	   public static void closeConn()  throws Exception
	   {
		   conn.close();
	   }
	  
	   
	}


