package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class step6gQ {

	public static void main(String[] args) {

		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
		    String q="select * from jdbc.emp";
		    pst=cn.prepareStatement(q);
		    rs=pst.executeQuery(q);
		    while (rs.next()) {
		    	System.out.println("id="+rs.getInt(1));
		    	System.out.println("firstname="+rs.getString(2));
		    	System.out.println("degree="+rs.getString(3));
		    	System.out.println("percentage="+rs.getInt(4));
		    	System.out.println("phnum="+rs.getInt(5));
				System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pst.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
