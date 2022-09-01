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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
			
//			HashMap<String,StudentDB> map = new Gson().fromJson(json.toString(),StudentDB.class);
//			Gson gson = new Gson();
//			HashMap map=gson.fromJson(json, StudentDB.class);
			
//			Enumeration enums = request.getHeaderNames();
//			while(enums.hasMoreElements()) {
//				String headerName=(String) enums.nextElement();
//				String headerValue=request.getHeader(headerName);
//				System.out.println(headerName+" "+headerValue);
//				
//			}
						
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
//			response.sendRedirect("http://localhost:8084/StudentDB/DisplayStudent");
			response.sendRedirect("displayTable.html");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
