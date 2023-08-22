package jdbc_maven_person;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class PersonCrud {
	private String name;
	private long phone;
	private String address;
	private int id;
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream=new FileInputStream("persondb.properties");
		
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		return connection;
	
	}
	public void savePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSONDB VALUES(?,?,?,?)");
		
		preparedStatement.setInt(1,person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getAddress());
		
		int result =preparedStatement.executeUpdate()	;
		if (result!=0) {
			System.out.println("Sign Up Succesfully");
			
		}
		else {
			System.out.println("Faild to Sign up");
			System.out.println("Please try again");
		}
		connection.close();
				
		
	}
             public void updatePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
            	 Connection connection=getConnection();
            	 PreparedStatement preparedStatement =connection.prepareStatement("UPDATE PERSONDB SET NAME=?, PHONE=?,ADDRESS=? WHERE ID=?");
            	 preparedStatement.setString(1, name);
            	 preparedStatement.setLong(2, phone);
            	 preparedStatement.setString(3, address);
            	 preparedStatement.setInt(4, id);
            	int result= preparedStatement.executeUpdate()	;	
            	if (result !=0) {
            		System.out.println("Updated");
					
				}
            	else {
					System.out.println("Not Updated");
				}
            	connection.close();
			}
             
             public void deletePerson(int id) throws ClassNotFoundException, IOException, SQLException {
            	 Connection connection=getConnection();
            	 PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM PERSONDB WHERE ID=?");
            	 preparedStatement.setInt(1, id);
            	int result= preparedStatement.executeUpdate();
            	if (result!=0) {
					System.out.println("Delete Succefully");
				}
            	else {
					System.out.println("Failed to Delete");
				}
            	connection.close();
				
			}
             
             public void findPersonID(int id) throws ClassNotFoundException, IOException, SQLException {
            	 Connection connection=getConnection();
            	 PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSONDB WHERE ID=?");
            	preparedStatement.setInt(1, id);
            	ResultSet resultset=preparedStatement.executeQuery() ;  
            	while (resultset.next()) {
            		System.out.println(resultset.getInt(id));
            		System.out.println(resultset.getString(2));
            		System.out.println(resultset.getLong(3));
            		System.out.println(resultset.getString("address"));
					
				}
            	connection.close();
            	
			}
             public void findAllPerson() throws ClassNotFoundException, IOException, SQLException {
            	 Connection connection=getConnection();
            	 PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSONDB ");
            	 ResultSet resultSet=preparedStatement.executeQuery();
            	 while (resultSet.next()) {
            		 System.out.println(resultSet.getInt(id));
            		 System.out.println(resultSet.getString(2));
            		 System.out.println(resultSet.getLong(3));
            		 System.out.println(resultSet.getString("address"));
					
				}
            	 connection.close();
            	 
				
			}
}
