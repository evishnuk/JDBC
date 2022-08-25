package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class STEP6iQ {

	public static void main(String[] args) throws Exception{
		Scanner scn=new Scanner(System.in);
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
			
			String sqlquery="insert into jdbc.student values(?,?,?,?)";
			PreparedStatement pst=cn.prepareStatement(sqlquery);
			while(true)
			{
			System.out.println("enter id");
			int id=scn.nextInt();
			System.out.println("enter firstname");
			String firstname=scn.next();
			System.out.println("enter lastname");
			String lastname=scn.next();
			System.out.println("enter degree");
			String degree=scn.next();
			pst.setInt(1,id);
			pst.setString(2,firstname);
			pst.setString(3,lastname);
			pst.setString(4,degree);
			pst.executeUpdate();
			System.out.println("congratulations");
			System.out.println("data inserted");
			System.out.println("do you want to insert one more record[yes/no]:");
			String option=scn.next();
			if (option.equalsIgnoreCase("yes")) {
				continue;
			}else if (option.equalsIgnoreCase("no")) {
				break;
			}else {
				break;
			}
			
			
		}	

	}
}

