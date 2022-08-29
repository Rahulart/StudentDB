package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class InsertStudent
 */
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement pst = con.prepareStatement("insert into studentdetails(uname,email,phoneNo,dept,gender) values(?,?,?,?,?)");
			pst.setString(1, request.getParameter("uname"));
			pst.setString(2, request.getParameter("email"));
			pst.setInt(3, Integer.parseInt(request.getParameter("phoneNo")));
			pst.setString(4, request.getParameter("dept"));
			pst.setString(5, request.getParameter("gender"));
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>Record inserted...</body></html>");
			response.sendRedirect("http://localhost:8083/StudentDB/display");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
