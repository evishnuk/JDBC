package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class uQ {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
        System.out.println("enter the percentage which you want to update");
        int percentage=scn.nextInt();
	    System.out.println("enter id for where condition");
	    int id=scn.nextInt();
	    String query="update jdbc.emp set percentage='"+percentage+"' where id="+id;
		PreparedStatement pst=cn.prepareStatement(query);
	    pst.execute(query);
	    System.out.println("updated successfully");
	  } catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	  

	}

}
