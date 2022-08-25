package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Registration {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Vishnu Kumar\\eclipse-workspace\\JDBC\\lib\\configaration.properties");
		    Properties p=new Properties();
		    p.load(fis);
		   // String dr=p.getProperty("driver");
		    String url=p.getProperty("url");
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("loading and registering completed");
		    cn=DriverManager.getConnection(url);
		    System.out.println("connection established");
		    
		    System.out.println("enter the following options");
		    System.out.println("enter 1 for login");
		    System.out.println("enter 2 for sign up");
		    int op=scn.nextInt();
		    switch (op) {
			case 1: {
				System.out.println("enter username");
				String username=scn.next();
				System.out.println("enter password");
				String password=scn.next();
				String q1="select * from advjava.registration where username='"+username+"'";
			    pst=cn.prepareStatement(q1);
			    pst.executeQuery();
			    String dbpass=rs.getString("password");
			    if (password.equals(dbpass)) {
			    	System.out.println("welcomr...... login sucessfull");
				}else {
					System.out.println("register first");
				}
				break;
			}
				case 2:
					while(true) {
					String q2="insert into advjava.registration values (?,?,?,?)";
					PreparedStatement pst2=cn.prepareStatement(q2);
					System.out.println("enter name");
					String name=scn.next();
					System.out.println("enter phnumber");
					int phnumber=scn.nextInt();
					System.out.println("enter username");
					String username=scn.next();
					System.out.println("enter password ");
					String password=scn.next();
					
					pst2.setString(1, name);
					pst2.setInt(2, phnumber);
					pst2.setString(3, username);
					pst2.setString(4, password);
					pst2.executeUpdate();
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
		
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
