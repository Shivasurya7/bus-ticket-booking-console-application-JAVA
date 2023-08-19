package classFiles;

public class bus {
	private String busType;
	private String SeatType;
	private int bookedSeat;
	private String[][] seat = new String[4][3];
	
	public bus(String busType,String seatType) {
		this.busType = busType;
		this.SeatType = seatType;
		this.bookedSeat = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				seat[i][j] = " ";
			}
		}
	}

	public String isCanBook(int n,String c) {
		n--;
		if(seat[n/3][n%3].isBlank()) {
			if(n <= 2) {
				if(seat[(n/3)+1][n%3].isBlank() || seat[(n/3)+1][n%3].equals(c)) {
					seat[n/3][n%3] = c;
					return "yes";
				}
				else {
					if(c.equals("F")) {
						return "Cannot book seat....Please choose female seat neighbour";
					}
					else {
						return "Cannot book seat....Please choose male seat neighbour";
					}	
				}
			}
			else if(n <= 5) {
				if(seat[(n/3)-1][n%3].isBlank() || seat[(n/3)-1][n%3].equals(c)) {
					System.out.println(seat[(n/3)-1][n%3]);
					seat[n/3][n%3] = c;
					return "yes";
				}
				else {
					if(c.equals("F")) {
						return "Cannot book seat....Please choose female seat neighbour";
					}
					else {
						return "Cannot book seat....Please choose male seat neighbour";
					}
				}
			}
			else if(n <= 8) {
				if(seat[(n/3)+1][n%3].isBlank() || seat[(n/3)+1][n%3].equals(c)) {
					seat[n/3][n%3] = c;
					return "yes";
				}
				else {
					if(c.equals("F")) {
						return "Cannot book seat....Please choose female seat neighbour";
					}
					else {
						return "Cannot book seat....Please choose male seat neighbour";
					}
				}
			}
			else if(n <= 11) {
				if(seat[(n/3)-1][n%3].isBlank() || seat[(n/3)-1][n%3].equals(c)) {
					seat[n/3][n%3] = c;
					return "yes";
				}
				else {
					if(c.equals("F")) {
						return "Cannot book seat....Please choose female seat neighbour";
					}
					else {
						return "Cannot book seat....Please choose male seat neighbour";
					}
				}
			}
		}
		else {
			return "Ticket is Already Booked";
		}
		return "Invalid Ticket Number";
	}
	
	public void displaySeat() {
		System.out.println("*->Driver");
		System.out.print("*  ");
		int s = 1;
		for(int i = 0; i < 4; i++) {
			if(i != 0) {
				System.out.print("   ");
			}
			if(s == 7) {
				System.out.println("-------->");
				System.out.print("   ");
			}
			for(int j = 0; j < 3; j++) {
				if(seat[i][j].isBlank()) {
					System.out.print(s+"  ");
				}
				else {
					System.out.print(seat[i][j]+"  ");
				}
				s++;
			}
			System.out.println();
		}
	}
	
	public void display() {
		System.out.println("Bus type : " + busType);
		System.out.println("Bus type : " + SeatType);
		System.out.println("Booked seats : " + bookedSeat);
	}
	
	
	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getSeatType() {
		return SeatType;
	}

	public void setSeatType(String seatType) {
		SeatType = seatType;
	}

	public int getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(int bookedSeat) {
		this.bookedSeat += bookedSeat;
	}
	public void delBookedSeat(int bookedSeat) {
		this.bookedSeat -= bookedSeat;
	}
}
