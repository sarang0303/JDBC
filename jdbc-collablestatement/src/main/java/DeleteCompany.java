import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;



public class DeleteCompany {
	public static void main(String[] args) throws SQLException, FileNotFoundException,IOException,ClassNotFoundException {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter a id");
		int id=scanner.nextInt();
		
		
		FileInputStream fileInputStream=new FileInputStream("company.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		CallableStatement callableStatement=connection.prepareCall("call companydb.delete_company(?)");
		callableStatement.setInt(1, id);
		int result=callableStatement.executeUpdate();
		if (result!=0) {
			System.out.println("Delete");
			
		}else {
			System.out.println("Failed");
		}
		connection.close();
		
		
		
		
	}
	
	

}
