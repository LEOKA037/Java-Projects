package taxi.main;

import taxi.util.Reservationlist;

public class Main {
	
	public static void main(String[] args) throws Throwable {
	
		TaxiReservation MainMenu= new TaxiReservation();
		Reservationlist.main(null);		
		MainMenu.main(null);
	}

}
