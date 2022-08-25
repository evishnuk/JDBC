package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class STEP2 {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//loading and registering completed
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
