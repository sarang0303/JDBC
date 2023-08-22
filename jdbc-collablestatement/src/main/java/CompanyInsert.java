import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CompanyInsert {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException,Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a id");
		int id=scanner.nextInt();
		
		System.out.println("Enter a Name");
		String name=scanner.next();
		
		System.out.println("Enter a gst");
		String gst=scanner.next();
		
		System.out.println("Enter a address");
		String address=scanner.next();
		
		System.out.println("Enter a phone no");
		Long phone=scanner.nextLong();
		
		FileInputStream fileInputStream=new FileInputStream("company.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection  connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
				CallableStatement callableStatement=connection.prepareCall("call companydb.company_insert(?,?,?,?,?)");
				callableStatement.setInt(1 , id);
				callableStatement.setString(2, name);
				callableStatement.setString(3, gst);
				callableStatement.setString(4, address);
				callableStatement.setLong(5, phone);
				
		int result=	callableStatement.executeUpdate();
		if (result!=0) {
			System.out.println("Inserted");
			
			
		}else {
			System.out.println("Failed");
		}
		
		connection.close();
		
		
	}

}
