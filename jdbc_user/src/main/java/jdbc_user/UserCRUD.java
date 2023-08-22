package jdbc_user;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UserCRUD {
	public Connection getConnection() throws Exception {
		FileReader fileReader = new FileReader("user.properties");
		Properties properties = new Properties();
		properties.load(fileReader);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;

	}

	public void signUpUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USER(ID,NAME,PHONE,EMAIL,PASSWORD)VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());

		preparedStatement.setString(5, user.getPassword());
		int count = preparedStatement.executeUpdate();
		if (count != 0) {
			System.out.println("Sign Up Succesfully");

		} else {
			System.out.println("Failed Sign Up");
			System.out.println("Please Try Again");
		}
		connection.close();

	}

	public boolean logInUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setInt(1, user.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");

		}
		connection.close();
		if (password != null)// to avoid a null pointer execetion
		{
			if (password.equals(user.getPassword())) {
				return true;

			} else {
				return false;
			}

		}
		return false;

	}

	public void displayPassword(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("The Saved Password are");
			System.out.println("Facebook :" + resultSet.getString("facebook"));
			System.out.println("Instagram :" + resultSet.getString("instagram"));
			System.out.println("Snapchat :" + resultSet.getString("snapchat"));
			System.out.println("Twitter :" + resultSet.getString("Twitter"));
		}
		connection.close();
	}
	public void updatePassword(User user) throws Exception {
	Connection connection=	getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("UPDATE USER SET FACEBOOK=?,INSTAGRAM=?,SNAPCHAT=?,TWITTER=? WHERE EMAIL=?");
	preparedStatement.setString(1, user.getFacebook());
	preparedStatement.setString(2, user.getInstagram());
	preparedStatement.setString(3, user.getSnapchat());
	
	preparedStatement.setString(4, user.getTwitter());
	preparedStatement.setString(5, user.getEmail());
	
int result=preparedStatement.executeUpdate();
if (result!=0) {
	System.out.println("Update Successfully");
	
}else {
	System.out.println("Failed to Upadte");
}
connection.close();
		
	}

}
