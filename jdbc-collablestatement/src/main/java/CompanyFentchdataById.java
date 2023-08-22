import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CompanyFentchdataById {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream=new FileInputStream("company.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		 
		Class.forName(properties.getProperty("className"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		CallableStatement callableStatement=connection.prepareCall("call companydb.fetch_data(?)");
		callableStatement.setInt(1,1);
	ResultSet resultSet=callableStatement.executeQuery();
	
	while (resultSet.next()) {
		System.out.println(resultSet.getInt(1));
		System.out.println(resultSet.getString("name"));
		System.out.println(resultSet.getString(3));
		System.out.println(resultSet.getString("address"));
		System.out.println(resultSet.getLong(5));
		
		
	}
	connection.close();
	}

}
