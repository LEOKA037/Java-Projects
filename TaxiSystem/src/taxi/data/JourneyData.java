package taxi.data;

import java.util.Scanner;

import taxi.main.TaxiReservation;

public class JourneyData {
	public static Scanner scanner;
	
	public JourneyData() {
		
	}

	public static String[] main(byte choice) throws Throwable {
				
		scanner = new Scanner(System.in);
		TaxiReservation Main= new TaxiReservation();
		
		String details[] = new String[5];
		String Date = null;
		String Time = null;
		String ToTime = null;
		String FromTime = null;
		int error=0;
		
		int checkTime = 0,checkToTime = 0,checkFromTime = 0,checkDate = 0;
		
		if(error==0)
		{
		// get date				
		taxi.data.Display.main(0);
		taxi.data.Display.main(9);
		try
		{
			Date = scanner.nextLine();
			checkDate=Main.isValidDate(Date);			
		} 
		catch (Exception e) 
		{
			error++;
			taxi.data.Display.main(11);
			
		}
	}
		// get Time		
		if(error==0)
		{
				taxi.data.Display.main(10);
		try
				{					
					Time = scanner.nextLine();
					checkTime=Main.isValidTime(Time);
				} 
				catch (Exception e) 
				{
					error++;
					taxi.data.Display.main(11);
				}
		}	
		
		// get FromTime	
		if(error==0)
		{
				taxi.data.Display.main(12);
		try
				{					
					FromTime = scanner.nextLine();
					checkFromTime=Main.isValidTime(FromTime);
				} 
				catch (Exception e) 
				{
					error++;
					taxi.data.Display.main(11);
					
				}
				
		}		
		// get ToTime	
		if(error==0)
		{
				taxi.data.Display.main(13);
				try
				{					
					ToTime = scanner.nextLine();
					checkToTime=Main.isValidTime(ToTime);	
				} 
				catch (Exception e) 
				{
					error++;
					taxi.data.Display.main(11);
				}
		}
		
		details[1]=Date;		
		details[2]=Time;		
		details[3]=FromTime;		
		details[4]=ToTime;
		
		int sum=checkTime+checkToTime+checkFromTime+checkDate;
		
		if(sum==4)
		{	
		return details;
		}

		else 
		{
			return null;
		}
		
	}

}
