package classFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class busData {
	Scanner cin = new Scanner(System.in);
	private ArrayList<bus> b = new ArrayList<bus>();
	private ArrayList<ticket> tickets = new ArrayList<ticket>();
	public busData(){
		bus b1 = new bus("AC","seater");
		bus b2 = new bus("AC","sleaper");
		bus b3 = new bus("NON-AC","seater");
		bus b4 = new bus("NON-AC","sleaper");
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
	}
	public void bookTickets(customer cus) {
		String bustype;
		String seattype;
		System.out.println("Enter bustype,seattype : ");
		bustype = cin.next();
		seattype = cin.next();
		for(int i = 0; i < b.size(); i++) {
			if(b.get(i).getBusType().equals(bustype) && b.get(i).getSeatType().equals(seattype)) {
				int noOfTicket;
				System.out.println("Enter the no of tickets you want to book : ");
				noOfTicket = cin.nextInt();
				int f = 0;
				ArrayList <Integer> bt = new ArrayList<Integer>();
				while(f != noOfTicket) {
					int ticketNo;
					String gender;
					System.out.println("Enter the seat number to be booked : ");
					ticketNo = cin.nextInt();
					System.out.println("Enter gender(M or F) : ");
					gender = cin.next();
					String result = b.get(i).isCanBook(ticketNo,gender);
					if(result.equals("yes")) {
						bt.add(ticketNo);
						f++;
					}
					else {
						System.out.println(result);
					}
				}
				b.get(i).setBookedSeat(noOfTicket);
				ticket t = new ticket(bustype,seattype,noOfTicket,bt,cus.getCustomerId());
				tickets.add(t);
				System.out.println("-------------------------------");
				System.out.println("Your Ticket id is: " + t.getTicketId());
				System.out.println("You have to pay Rs." + t.getPrice());
				System.out.println("Your Tickets were booked");
				System.out.println("!!!!Happy Journey!!!!");			
				System.out.println("-------------------------------");
				break;
			}
		}
		return;
	}
	
	public void viewTicket() {
		String bt;
		String st;
		System.out.println("Enter bustype,seattype : ");
		bt = cin.next();
		st = cin.next();
		for(int i = 0; i < b.size(); i++) {
			if(b.get(i).getBusType().endsWith(bt) && b.get(i).getSeatType().equals(st)) {
				b.get(i).displaySeat();
				break;
			}
		}
	}
	public void cancelTickets() {
		int id;
		System.out.println("Enter booking id");
		id = cin.nextInt();
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).getTicketId() == id) {
				System.out.println("-----------------------");
				System.out.println("Ticket details are : ");
				System.out.println("Bus type : " + tickets.get(i).getBusType());
				System.out.println("Seat type : " + tickets.get(i).getSeatType());
				System.out.println("Booked by the customer id : " + tickets.get(i).getCusId());
				System.out.println("No. of tickets : " + tickets.get(i).getNoOfTickets());
				System.out.println("Booked seates : " + tickets.get(i).getBookedSeates());
				System.out.println("-----------------------");
				System.out.println("Your ticket has been deleted successfully!!!\r\n"
						+ "Your amount " + tickets.get(i).getPrice() +" will return back soon...\r\n"
						+ "Thank you");
				for(int j = 0; j < b.size(); j++) 
					if(b.get(j).getBusType().equals(tickets.get(i).getBusType()) && b.get(j).getSeatType().equals(tickets.get(i).getSeatType()))
						b.get(j).delBookedSeat(tickets.get(i).getNoOfTickets());
				tickets.remove(i);
				break;
			}
		}
	}
	
	public void summary() {
		System.out.println("Bus summary : ");
		System.out.println("------------------------");
		for(int i = 0; i < b.size(); i++) {
			b.get(i).display();
			System.out.println("------------------------");
		}	
	}
}
