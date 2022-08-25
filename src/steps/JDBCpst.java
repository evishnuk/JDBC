package steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCpst {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		Connection cn=null;
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		PreparedStatement pst3=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("load and register completed");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=dcba&&userSSL=false");
			System.out.println("connection established");
			
			
			String q="insert into jdbc.emp values(?,?,?,?,?)";  //inserting
			pst=cn.prepareStatement(q);
			while (true) {
				System.out.println("enter id");
				int id=scn.nextInt();
				System.out.println("enter name");
				String name=scn.next();
				System.out.println("enter degree");
				String degree=scn.next();
				System.out.println("enter percentage");
				int percentage=scn.nextInt();
				System.out.println("enter phnum");
				int phnum=scn.nextInt();
				
				pst.setInt(1, id);
				pst.setString(2,name);
				pst.setString(3, degree);
				pst.setInt(4, percentage);
				pst.setInt(5, phnum);
				pst.executeUpdate();
				System.out.println("data updated successfully");
				System.out.println("if you want to enter more records[yes/no]:");
				String option=scn.next();
				if (option.equalsIgnoreCase("yes")) {
					continue;
				}else if (option.equalsIgnoreCase("no")) {
					break;
				}else {
					break;
				}
			}
			
			
			
//			System.out.println("enter the percentage which you want to update");  //updateing
//			int percentage=scn.nextInt();
//			System.out.println("enter id for where condition");
//			int id=scn.nextInt();
//			String q1="update jdbc.emp set percentage="+percentage+" where id="+id;
//			pst1=cn.prepareStatement(q1);
//			pst1.executeUpdate();
//			System.out.println("updated successfully");
			
			
//			String q2="select * from jdbc.emp";            //getting
//			pst2=cn.prepareStatement(q2);
//			rs=pst2.executeQuery();
//			while (rs.next()) {
//				System.out.println("id="+rs.getInt(1));
//				System.out.println("name="+rs.getString(2));
//				System.out.println("degree="+rs.getString(3));
//				System.out.println("percentage="+rs.getInt(4));
//				System.out.println("phnum="+rs.getInt(5));
//				System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _");
//			}
			
//			System.out.println("enter id which you want to delete");   //deleting
//			int id=scn.nextInt();
//			String q3="delete from jdbc.emp where id="+id;
//			pst3=cn.prepareStatement(q3);
//			pst3.executeUpdate();
//			System.out.println("data deleted");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				pst.close();
				pst1.close();
				pst2.close();
				pst3.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
