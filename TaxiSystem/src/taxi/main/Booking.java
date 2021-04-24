package taxi.main;

import java.util.Scanner;

public class Booking extends TaxiReservation{
	
	byte choice;

	public void main(String[] args) throws Throwable 
	{
		TaxiReservation MainMenu= new TaxiReservation();
		scanner = new Scanner(System.in);
		
		taxi.data.Display.main(0);
		taxi.data.Display.main(2);
		taxi.data.Display.main(7);
		
		try {
			choice=scanner.nextByte();
		} 
		catch (Exception e) 
		{
			
		}
		
		
		if (choice==9)
		{
			MainMenu.main(null);
		}
				
		else if (choice<1||choice>6)
			{
			taxi.data.Display.main(0);
			taxi.data.Display.main(5);
			taxi.data.Display.main(6); 
			}
		else if (choice==6)
		{			
			taxi.data.Display.main(0);
			taxi.data.Display.main(4);
			taxi.data.Display.main(6);
		}
		else
		{
			taxi.util.Bookcab.main(choice);
		}
	}
	

}
