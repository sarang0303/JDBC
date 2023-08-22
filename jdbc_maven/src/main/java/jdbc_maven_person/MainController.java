package jdbc_maven_person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;



public class MainController {
	
	

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner scanner=new Scanner(System.in);
		
		Person person=new Person();
		PersonCrud crud=new PersonCrud();
		boolean condition=true;
		do {
			System.out.println("Enter the choice\n1.save person\n2.Update person \n3.Delete person\n4.find one person\n5.find all person");
			int choice=scanner.nextInt()	;
			switch (choice) {
			case 1:{
				System.out.println("Enter id");
				int id =scanner.nextInt();
				
				System.out.println("Enter Name");
				String name= scanner.next()	;
				
				
				System.out.println("Enter the phone");
				long phone =scanner.nextLong()	;
				
				System.out.println("Enter Address");
				String address=scanner.next()	;
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				
				crud.getConnection();
				crud.savePerson(person);
				
			}
			
				
				break;
				
				
			case 2:{
				System.out.println("Enter id");
				int id = scanner.nextInt();
				 
				 
				System.out.println("Enter Name");
				String name= scanner.next()	;
				
				
				System.out.println("Enter the phone");
				long phone =scanner.nextLong()	;
				
				System.out.println("Enter Address");
				String address=scanner.next()	;
				
			
		        person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				
			
				crud.updatePerson(person);
				
			}
			
				
				break;
			case 3:{
				System.out.println("Enter id");
				int id = scanner.nextInt();
				crud.deletePerson(id);
				
			}
			
				
				break;
				
			case 4:{
				System.out.println("Enter id");
				int id = scanner.nextInt();
				crud.findPersonID(id);
				
			}
			
				
				break;
				
			case 5:{
				crud.findAllPerson();
			}
				
			break;
			default :
				condition=false;
			}
		} while(condition);
	}
}

		
		
		
	
	
	


