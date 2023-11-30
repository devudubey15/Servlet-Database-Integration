

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class personserve1
 */
public class personserve1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");// in servelet we have to write this line 
			String url="jdbc:mysql://localhost:3306/bit";
			con=DriverManager.getConnection(url,"root","devasheesh");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age").trim());
			PreparedStatement pst=con.prepareStatement("insert into person(name,age) values(?,?)");
			pst.setString(1,name);
			pst.setInt(2,age);
			int k=pst.executeUpdate();
			if(k>0)
			{
				pw.println("Record has been added");
			}
			else
			{
				pw.println("cannot add");
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}
//