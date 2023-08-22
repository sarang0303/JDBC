package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class Studentinsert 
{
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a id");
		int id=scanner.nextInt()	;
		
		System.out.println("Enter a Name");
		String name=scanner.next();
		
		System.out.println("Enter a Marks");
		int marks=scanner.nextInt();
		
		System.out.println("Enter the Phoneno");
		long phoneno=scanner.nextLong();
		
		System.out.println("Enter the Address");
		String address=scanner.next()	;	
		
		
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String password="root";
		String query="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		
		
	Driver driver =new Driver()	;
	DriverManager.registerDriver(driver);
	Connection connection =DriverManager.getConnection(url,user,password);
   PreparedStatement preparedStatement= connection.prepareStatement(query);
   preparedStatement.setInt(1, id);
   preparedStatement.setString(2, name);
   preparedStatement.setInt(3, marks);
   preparedStatement.setLong(4, phoneno);
   preparedStatement.setString(5, address);
   
   preparedStatement.execute() ;
   System.out.println("Inserted");
   connection.close();
   
    
	
		
		
	}
	
	

}
