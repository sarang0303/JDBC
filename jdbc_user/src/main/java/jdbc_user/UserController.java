package jdbc_user;

import java.util.Scanner;

public class UserController {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		
		UserCRUD crud=new UserCRUD();
		User user=new User();
		System.out.println("Enter the choice \n1.SignUp \n2.LogIn \n3.Exist ");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:{
			System.out.println("Enter id");
			int id =scanner.nextInt();
			
			System.out.println("Enter Name");
			String name= scanner.next()	;
			
			
			System.out.println("Enter the phone");
			long phone =scanner.nextLong()	;
			
			System.out.println("Enter email");
			String email=scanner.next();
			
			System.out.println("Enter Password");
					String password =scanner.next();
					user.setId(id);
					user.setName(name);
					user.setPhone(phone);
					user.setEmail(email);
					user.setPassword(password);
					crud.signUpUser(user);
		}
			
			break;
			case 2:{
				System.out.println("Enter the email");
				String email= scanner.next();
				
				System.out.println("Enter the Password");
				String password= scanner.next();
				
				user.setEmail(email);
				user.setPassword(password);
				
				boolean result=crud.logInUser(user);
				if (result) {
					System.out.println("Log In Successfully");
					crud.displayPassword(email);
					
					
					System.out.println("Enter the choice\n1 Update the password\n2.Log Out");
					int key=scanner.nextInt();
					
					switch (key) {
					case 1:{
						System.out.println("Enter the facebook password");
						user.setFacebook(scanner.next());
						
						System.out.println("Enter the Instagram password");
						user.setInstagram(scanner.next());
						
						System.out.println("Enter the Snapchat Password");
						user.setSnapchat(scanner.next());
						
						System.out.println("Enter the Twitter password");
						user.setTwitter(scanner.next());
						
					
						crud.updatePassword(user);
					}
						
						break;

					default:
						break;
					}
					
				}
				else {
					System.out.println("Invalid Credentials");
				}
				
				
				
				}

		default:
			break;
		}
	}

}
