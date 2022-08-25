package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dQ {
	public static void main(String[] args) {
		Scanner scn=new Scanner( System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
			System.out.println("enter id which you want to delete");
		    int id=scn.nextInt();
			String quary="delete from jdbc.emp where id="+id;
			PreparedStatement pst=cn.prepareStatement(quary);
		    pst.executeUpdate(quary);
		    System.out.println("data deleted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
