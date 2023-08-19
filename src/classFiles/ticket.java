package classFiles;

import java.util.ArrayList;

public class ticket {
	private  static int ticketNo = 0;
	private int cusId;
	private String busType;
	private String seatType;
	private int NoOfTickets;
	private ArrayList<Integer> bookedSeates;
	private int ticketId;
	private int price;
	public ticket(String bt,String st,int not,ArrayList<Integer> a,int cus) {
		this.setTicketId(ticketNo);
		this.setCusId(cus);
		this.setBusType(bt);
		this.setSeatType(st);
		this.setNoOfTickets(not);
		this.price = not*setPrice(bt,st);
		this.setBookedSeates(a);
		ticketNo++;
	}
	public int setPrice(String bt,String st) {
		if(bt.equals("AC")) {
			if(st.equals("seater")) {
				return 500;
			}
			else {
				return 600;
			}
		}
		else {
			if(st.equals("seater")) {
				return 200;
			}
			else {
				return 400;
			}
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<Integer> getBookedSeates() {
		return bookedSeates;
	}
	public void setBookedSeates(ArrayList<Integer> bookedSeates) {
		this.bookedSeates = bookedSeates;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public int getNoOfTickets() {
		return NoOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		NoOfTickets = noOfTickets;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
}
