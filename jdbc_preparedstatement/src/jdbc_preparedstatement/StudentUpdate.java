package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentUpdate {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID");
		int id = scanner.nextInt();

		System.out.println("Enter name");
		String name = scanner.next();

		System.out.println("Ente marks");
		int marks = scanner.nextInt();

		System.out.println("Enter phoneno");
		long phoneno = scanner.nextLong();

		System.out.println("Enter addrerss");
		String address = scanner.next();

		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";
		String query = "UPDATE STUDENT SET NAME =?,MARKS=?,PHONENO=?,ADDRESS=? WHERE ID=?";

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);

		preparedStatement.setInt(2, marks);
		preparedStatement.setLong(3, phoneno);
		preparedStatement.setString(4, address);
		preparedStatement.setInt(5, id);

		int countainer = preparedStatement.executeUpdate();

		if (countainer != 0) {
			System.out.println("Updated");

		} else {
			System.out.println("Failed");

		}
		connection.close();

	}

}
