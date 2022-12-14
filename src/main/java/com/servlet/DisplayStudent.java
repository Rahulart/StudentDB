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
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class DisplayStudent
 */
@WebServlet("/DisplayStudent")
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
		
		HashMap<Integer,StudentDB> map = new HashMap<Integer,StudentDB>();
		StudentDB sDB;
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement pst = con.prepareStatement("select * from studentdetails");
			ResultSet rs = pst.executeQuery();
			
			PrintWriter out = response.getWriter();
//			response.setContentType("text/html");
//			out.println("<html><head>");
//			out.println("<style>h2{\r\n"
//					+ "	margin-top: 5rem;\r\n"
//					+ "	text-align: center;\r\n"
//					+ "}\r\n"
//					+ "table{\r\n"
//					+ "	margin: 0.5rem auto;\r\n"
//					+ "	margin-top: 3rem;\r\n"
//					+ "	border-collapse: collapse;\r\n"
//					+ "}\r\n"
//					+ "th,td{\r\n"
//					+ "	border: 1px solid #000000;\r\n"
//					+ "	padding: 0.6rem;\r\n"
//					+ "}</style>");
//			out.println("</head><body>");
//			out.println("<table>");
//			out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone no.</th><th>Deptartment</th><th>Gender</th>");
//			List<studentdetails> li=new List<>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String uname=rs.getString("uname");
				String email=rs.getString("email");
				int phoneNo=rs.getInt("phoneNo");
				String dept=rs.getString("dept");
				String gender=rs.getString("gender");
//				System.out.println(uname);
				sDB=new StudentDB(id,uname,email,phoneNo,dept,gender);
				map.put(id, sDB);
				
//				out.println("<tr><td>"+id+"</td><td>"+uname+"</td><td>"+email+"</td><td>"+phoneNo+"</td><td>"+dept+"</td><td>"+gender+"</td></tr>");
//				out.println(id);
//				break;
				
			}
//			out.println("</table>");
//			out.println("</body></html>");
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Integer i:map.keySet()) {
			StudentDB studDB=map.get(i);
			System.out.println(studDB.getId()+" "+studDB.getUname()+" "+studDB.getEmail()+" "+studDB.getPhoneNo()+" "+studDB.getDept()+" "+studDB.getGender());
		}
		
//		for(Integer i:map.keySet()) {
//			StudentDB studDB=map.get(i);
//			System.out.println(studDB.toString());
//		}
		
//		JSONObject json=new JSONObject();
//		json.putAll(map);
//        System.out.printf( "JSON: %s", json);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		System.out.println(jsonStr);
		response.getWriter().print(jsonStr);
//		response.getWriter().print("Hello world");
		
//		JSONObject jsonObj=new JSONObject();
//		String jsonOBJ=jsonObj.toJSONString(map);
//				System.out.println(jsonOBJ);
	}


}
