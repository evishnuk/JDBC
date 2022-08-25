package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loading and registering completed");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
			System.out.println("connection established");
			
			
			Statement st=cn.createStatement();
			st.execute("insert into jdbc.stud values (5,'yash','bba',75,2022,'yash@gmail.com')");  //inserting
			System.out.println("congratulations");
			System.out.println("data inserted");
			
			
//			ResultSet rs=st.executeQuery("select * from jdbc.stud");  //getting
//			while (rs.next()) {
//				System.out.println("id="+rs.getInt(1));
//				System.out.println("name="+rs.getString(2));
//				System.out.println("degree="+rs.getString(3));
//				System.out.println("percentage="+rs.getInt(4));
//				System.out.println("yop="+rs.getInt(5));
//				System.out.println("mail="+rs.getString(6));
//				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
//			}
			
//			System.out.println("enter the percentage which you want to update"); //updateing
//			int percentage=scn.nextInt();
//			System.out.println("enter id for where condition");
//			int  id=scn.nextInt();
//			String query="update jdbc.stud set percentage="+percentage+" where id="+id;
//			st.execute(query);
//			System.out.println("data updated successfully");
			
//			System.out.println("enter id which you want to delete"); //deleting
//			int id=scn.nextInt();.
//			String query="delete from jdbc.stud where id="+id;
//			st.execute(query);
//			System.out.println("data deleted sucessfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
