//import java.sql.*;
//public class App1 
//{
//	public static void main(String args[])
//	{
//		String ss="jdbc:mysql://localhost:3306/bit";
//		try(Connection con=DriverManager.getConnection(ss,"root","devasheesh"))
//		{
//			System.out.println("Implementation class is\t"+con.getClass()); 
//			Statement st=con.createStatement();
//			ResultSet rs=st.executeQuery("select * from dept");
//			
//			while(rs.next())
//			{
//				int no=rs.getInt("deptno");
//				String name=rs.getString("dname");
//				String add=rs.getString("loc");
//				System.out.println(no+"\t"+name+"\t"+add);
//			}
//		}
//		catch(Exception ee)
//		{
//			System.out.println(ee);
//		}
//	}
//}	
//
Question 2
import java.sql.*;
public class App1
{
	public static void main(String args[]) throws SQLException
	{
		String ss = "jdbc:mysql://localhost:3306/bit";
		try(Connection con = DriverManager.getConnection(ss,"root","devasheesh"))
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from dept");
			ResultSetMetaData rms = rs.getMetaData();
			int col= rms.getColumnCount();
			for(int i =1;i<col;i++)
			{
				System.out.println(rms.getColumnName(i));
			}
			while(rs.next())
			{
				System.out.println("\n");
				for(int i = 1; i<=col;i++)
				{
					System.out.print(rs.getObject(rms.getColumnName(i))+"\t" );
					System.out.print(rs.getObject(i)+"\t");
				}
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
}





