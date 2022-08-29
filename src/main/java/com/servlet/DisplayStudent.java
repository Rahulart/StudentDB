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
import java.sql.ResultSet;

/**
 * Servlet implementation class DisplayStudent
 */
public class DisplayStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement pst = con.prepareStatement("select * from studentdetails");
			ResultSet rs = pst.executeQuery();
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html><body>");
			out.println("<table>");
			out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone no.</th></tr>");
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String uname=rs.getString("uname");
				String email=rs.getString("email");
				int phoneNo=rs.getInt("phoneNo");
//				System.out.println(uname);
				
				out.println("<tr><td>"+id+"</td><td>"+uname+"</td><td>"+email+"</td><td>"+phoneNo+"</td></tr>");
//				out.println(id);
//				break;
				
			}
			out.println("</table>");
			out.println("</body></html>");
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
