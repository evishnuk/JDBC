package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class STEP4 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
			Statement st=cn.createStatement();
			System.out.println("sucess");
			
			st.execute("insert into jdbc.student values (1,'vishu','kumar','bcom')");
		
			System.out.println("congratulations");
			System.out.println("data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
