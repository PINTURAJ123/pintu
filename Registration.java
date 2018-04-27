package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

		
		protected void dopost (HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			try{
				String name=request.getParameter("user");
				String password=request.getParameter("password");
				String sql="insert into portal(name,password)value(?,?)";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:33066/apna","root","");
		               
				 PreparedStatement ps=con.prepareStatement(sql);
				 ps.setString(1,name);
				 ps.setString(2, password);
				 ps.executeUpdate();
				 PrintWriter out=response.getWriter();
				 out.println("you have succesfully registered");
			
			}		
			catch(ClassNotFoundException e){
				  e.printStackTrace();
			}
			catch(SQLException e){
				 e.printStackTrace();
			}
		}

}
