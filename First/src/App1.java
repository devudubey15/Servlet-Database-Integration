import java.sql.*;
public class App1 
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/bit";
		try(Connection con=DriverManager.getConnection(ss,"root","devasheesh"))
		{
			//System.out.println("Implementation class is\t"+con.getClass()); 
			//Statement st=con.createStatement();
			//ResultSet rs=st.executeQuery("select * from dept");
			//while(rs.next())
			//{
			//	int no=rs.getInt("deptno");
			//	String name=rs.getString("dname");
			//	String add=rs.getString("loc");
			//	System.out.println(no+"\t"+name+"\t"+add);
			//}
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select * from dept);
			ResultMatadata rms = rs.getMetaData();
			int col = rs.getColumnCount();
//			for(int i =1;i<col;i++)
//			{
//				System.out.println(rs.getColumnName(i));
//			}
}
catch(Exception ee)
{
	System.out.println(ee);
}
}
}	



//import java.sql.*;
//public class App1
//{
//	public static void main(String args[])
//	{
//		String ss = "jdbc:mysql://localhost:3306/bit";
//		try(Connection con = DriverManager.getConnection(ss,"root","devasheesh")){
//			
//		}
//		catch(Exception ee)
//		{
//			System.out.println(ee);
//		}
//	}
//}						
			