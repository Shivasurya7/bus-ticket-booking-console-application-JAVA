import java.util.ArrayList;
import java.util.Scanner;

import classFiles.busData;
import classFiles.customer;
public class mainmenu {
	private static ArrayList <customer> customer = new ArrayList();
	static busData bus = new busData();
	static Scanner cin = new Scanner(System.in);
	public static void main(String args[]) {
		int n,f=0;
		Scanner cin = new Scanner(System.in);
		while(true) {
			System.out.println("1)Sign up\r\n"
					+ "2)Login\r\n"
					+ "3)Exit ");
			System.out.println("Enter your choose : ");
			n = cin.nextInt();
			switch(n) {
			case 1:
				signUp();
				break;
			case 2:
				int s;
				s = logIn();
				if(s != -1) {
					System.out.println("login sucessfull.....");
					System.out.println("welcome "+ customer.get(s).getCustomerName());
					int f2 = 0;
					while(true) {
						System.out.println("\n1)BookTickects\r\n"
								+ "2)ViewTickets\r\n"
								+ "3)CancelTickets\r\n"
								+ "4)Summary\r\n"
								+ "5)Logout");
						System.out.println("Enter your choose : ");
						n = cin.nextInt();
						switch(n) {
						case 1:
							bus.bookTickets(customer.get(s));
							break;
						case 2:
							bus.viewTicket();
							break;
						case 3:
							bus.cancelTickets();
							break;
						case 4:
							bus.summary();
							break;
						case 5:
							System.out.println("logout sucessfull.....");
							f2 = 1;
							break;
						}
						if(f2 == 1) {
							break;
						}
					}
				}
				else {
					System.out.println("User id or Password is invalid\n try angain");
				}
				break;
			case 3:
				f = 1;
				break;
			}
			if(f == 1) {
				break;
			}
		}
	}
	public static void signUp() {
		int id; 
		String name; 
		String password; 
		int age;
		char gender;
		System.out.println("Enter Customer id  : ");
		id = cin.nextInt();
		System.out.println("Enter Customer name : ");
		name = cin.next();
		System.out.println("Enter Password : ");
		password = cin.next();
		System.out.println("Enter Age : ");
		age = cin.nextInt();
		System.out.println("Enter Gender : ");
		gender = cin.next().charAt(0);
		if(validateId(id)) {
			System.out.println("User id exist...\ntry new user id");
		}
		else {
			customer cus = new customer(id,name,password,age,gender);
			customer.add(cus);
		} 
	}
	public static int logIn() {
		int id; 
		String password;
		System.out.println("Enter Customer id : ");
		id = cin.nextInt();
		System.out.println("Enter Password to Login : ");
		password = cin.next();
		for(int i = 0; i < customer.size(); i++) {
			if(customer.get(i).getCustomerId() == id) {
				if(customer.get(i).getPassword().equals(password)) {
					return i;
				}
				else {
					return -1;
				}
			}
		}
		return -1;

	}
	public static boolean validateId(int id) {
		for(int i = 0; i < customer.size(); i++) {
			if(customer.get(i).getCustomerId() == id) {
				return true;
			}
		}
		return false;
	}
}
