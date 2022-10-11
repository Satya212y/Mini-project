package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet("/new")
public class LeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LeadController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "5555");
			System.out.println(con);
			Statement stmt = con.createStatement();
			ResultSet executeQuery = stmt.executeQuery("select * from registration ");
System.out.println(executeQuery);
		} catch (Exception e) {
         e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "5555");
			System.out.println(con);
			Statement stmt = con.createStatement();
			stmt.executeUpdate("select * from registration where id IN(1,2,3)");
		} catch (Exception e) {
         e.printStackTrace();
		}
	}

}
