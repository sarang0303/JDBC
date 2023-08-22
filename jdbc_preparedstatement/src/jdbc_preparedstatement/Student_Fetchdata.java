package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Student_Fetchdata {
	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query="SELECT * FROM STUDENT WHERE ID=?";
				Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, 2);
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next()) {
		System.out.println(resultSet.getInt(1));
		System.out.println(resultSet.getString("name"));
		System.out.println(resultSet.getInt(3));
		System.out.println(resultSet.getLong("phoneno"));
		System.out.println(resultSet.getString(5));
		}
		connection.close();
		
				
	}
	

}
