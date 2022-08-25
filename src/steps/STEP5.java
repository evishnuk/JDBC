package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class STEP5 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
		    Statement st=cn.createStatement();
		    ResultSet rs=st.executeQuery("select * from jdbc.student");
		    while (rs.next()) {
		    	System.out.println("id="+rs.getInt(1));
		    	System.out.println("firstname="+rs.getString(2));
		    	System.out.println("lastname="+rs.getString(3));
		    	System.out.println("degree="+rs.getString(4));
		    	System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
