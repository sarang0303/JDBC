package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a id");
		int id=scanner.nextInt();
		
		
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String password="root";
		String query="DELETE FROM STUDENT WHERE ID=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection= 	DriverManager.getConnection(url, user, password);
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	preparedStatement.setInt(1, id);
	int result=preparedStatement.executeUpdate();
	if (result!=0) {
		System.out.println("Delete data Succefully");
		
		
	}
	else {
		System.out.println("Failed to delete");
	}
	connection.close();
	
	}

}
