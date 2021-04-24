package taxi.data;

import java.util.Scanner;
import taxi.main.TaxiReservation;

public class Display {
	
	public static Scanner scanner;
	
	public static void main(int screen) throws Throwable
	{
		TaxiReservation MainMenu= new TaxiReservation();
		scanner = new Scanner(System.in);
		byte choice = 0;
		switch (screen) 
		{
		case 0:
		{
			System.out.print("--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\n\t\t\t\t\t\tTaxi Reservation System"
					+ "\n-------------------------------------------------------------------------------------------------------------------------------------"
					+ "-");
			break;
		}
		case 1:
		{
			System.out.print("\n\t\t\t\t\t\t\tWelcome"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\n1.	Book A Cab"
					+ "\n2.	Cancel A Reservation"
					+ "\n3.	Exit"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\n");
			break;
		}
		case 2:
		{
			System.out.print("\n\t\t\t\t\t\t  Book A Cab – Type"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\n\t\t\t\t\tCab Type"
					+ "\n1.Car-Hatchback"
					+ "\n2.Car-Sedan"
					+ "\n3.Car-Luxury"
					+ "\n4.Van-Innova"
					+ "\n5.Van-Tavera"
					+ "\n6.Exit"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\n");
			break;
		}
		case 3:
		{
			System.out.print("\n\t\t\t\t\t\t         Cancel"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\nEnter Reservation Number :"
					+ " ");
			break;
		}
		case 6:
		{
			System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\n\t\t\t\t\t\t Java Learning Project"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------");
			break;
		}
		case 7:
		{
			System.out.print("\nPress 9 for going back to Previous Menu\n");
			break;
		}
		case 8:
		{
			System.out.print("\nPress 9 for going back to Main Menu\n");
			break;
		}
		case 9:
		{
			System.out.print("\nBook A Cab – Date And Time"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\nEnter Date (YYYY-MM-DD): ");
			break;
		}
		case 10:
		{
			System.out.print("\nEnter Time(HH-mm-ss)       :");
			break;
		}
		case 12:
		{
			System.out.print("\nEnter From Time(HH-mm-ss)   :");
			break;
		}
		case 13:
		{
			System.out.print("\nEnter ToTime(HH-mm-ss)      :");
			break;
		}
		case 4:
		{
			System.out.print("\n\t\t\t\t\t     Thank You Using the Application");
			taxi.data.Logger.main(null);
			break;
		}
		case 5:
		{
			System.out.print("\n\t\t\t\t\t\t   Wrong Information");
			taxi.data.Display.main(8);;
			
			try {
				choice=scanner.nextByte();
			} 
			
			catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			break;
		}
		case 11:
		{
			System.out.print("\n\t\t\t\t\t\tInvalid Format");
			taxi.data.Display.main(8);
			
			try {
				choice=scanner.nextByte();
			} 
			
			catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			
			break;
		}
		case 19:
		{
			System.out.print("\nJourney Date should be atleast one week prior to the current date");
			taxi.data.Display.main(8);
			try {
				choice=scanner.nextByte();
			} catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			
			break;
		}
	}
	}

	public static void main(int screen,String[] reserveddetails) throws Throwable 
	{
		TaxiReservation MainMenu= new TaxiReservation();
		scanner = new Scanner(System.in);

		byte choice = 0;
				
		switch (screen) 
		{
		case 15:
		{
			
			System.out.print("\nConfirmation"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\nCab Type		           :"+reserveddetails[2]+""
					+ "\nDate			           :"+reserveddetails[3]+""
					+ "\nTime			           :"+reserveddetails[4]+""
					+ "\nCab "+reserveddetails[1]+" confirmed from "+reserveddetails[6].replace("-", ":")+" to "+reserveddetails[7].replace("-", ":")
					+ "\nReservation Number        : "+reserveddetails[5]
					+"\n-------------------------------------------------------------------------------------------------------------------------------------"
					+ "-");
			taxi.data.Display.main(8);
			
			try {
				choice=scanner.nextByte();
			} catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			break;		
		}
		
		case 16:
		{
			System.out.print("\nUnavailable"
					+ "\n--------------------------------------------------------------------------------------------------------------------------------------"
					+ "\nCab Type		           :"+reserveddetails[2]+""
					+ "\nDate			           :"+reserveddetails[3]+""
					+ "\nTime			           :"+reserveddetails[4]+""
					+ "\nCab Not Available"
					+"\n-------------------------------------------------------------------------------------------------------------------------------------"
					+ "-");
			taxi.data.Display.main(8);
			try {
				choice=scanner.nextByte();
			} catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			break;	
		}		
		
		
		default:
			break;
	}


	}
	
	public static void main(int screen,String ReservationNumber) throws Throwable{
	
		TaxiReservation MainMenu= new TaxiReservation();
		scanner = new Scanner(System.in);
		byte choice = 0;
		
		switch (screen) 
		{
		case 17:
		{
			System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------"
					+"\n"+ReservationNumber+" is an invalid ReservationNumber");
			taxi.data.Display.main(8);
			try {
				choice=scanner.nextByte();
			} catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			break;
		}
		case 18:
		{
			System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------"
					+"\n"+ReservationNumber+" was not found"
					+"\n-------------------------------------------------------------------------------------------------------------------------------------"
					+ "-");
			taxi.data.Display.main(8);
			try {
				choice=scanner.nextByte();
			} catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			break;
		}
		}
	}

	public static void main(int screen,String CabNumber,String ReservationNumber) throws Throwable
	{
		TaxiReservation MainMenu= new TaxiReservation();
		scanner = new Scanner(System.in);	
		byte choice = 0;
				
		switch (screen) 
		{
		case 14:
		{
			System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------"
					+"\n"+ReservationNumber+" Cancelled Successfully"+"\n"
					+ "Reservation of Cab Number :"+CabNumber+" have been cancelled"
					+"\n-------------------------------------------------------------------------------------------------------------------------------------"
					+ "-");
			taxi.data.Display.main(8);
			try {
				choice=scanner.nextByte();
			} catch (Exception e) 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			if (choice==9)
				MainMenu.main(null);
			else 
			{
				taxi.data.Display.main(0);
				taxi.data.Display.main(5);
				taxi.data.Display.main(6);
			}
			break;
		}
	}
}
}

