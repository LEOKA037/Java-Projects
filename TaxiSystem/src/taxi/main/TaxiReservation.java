package taxi.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class TaxiReservation {
	
	public static Scanner scanner;
		
	public static LinkedList<String> availablelist= new LinkedList<String>(); 
	
	//method to check the validity of the date
	public int isValidDate(String DateTime) {
		
		SimpleDateFormat format = new java.text.SimpleDateFormat("YYYY-MM-DD");
		int Month = Integer.parseInt(DateTime.substring(5,7));
		int Date = Integer.parseInt(DateTime.substring(8,10));	
		
		try
 		{
			format.parse(DateTime);
			
 			if(Month>12||Date>31)
 			{
 				return 0;
 			}
 			else{
 				return 1;
 			}
			
 			
 		}
 		catch (ParseException e) {

 			return 0;
 		}
	}
	
	//method to check the validity of the time
	public int isValidTime(String Time) 
	{
		
		SimpleDateFormat format = new java.text.SimpleDateFormat("HH-mm-ss");
		String Timestamp=Time;
		int Hour = Integer.parseInt(Time.substring(0,2));
		int Minute = Integer.parseInt(Time.substring(3,5));
		int Seconds = Integer.parseInt(Time.substring(6,7));	
	
		try{
            format.parse(Timestamp);
            if(Hour<=24 && Minute<=60 && Seconds <=60)
            {
            	return 1;
            }
            else
            {
            	return 0;
            }     
        }
        catch(ParseException e) 
		{
       	return 0;
        }
	}
	
	//method to externalise the string constants
	public LinkedList<String> getConfigFile(String[] ags) 
	{	
		//Path of the Information File 
		String workingDir = System.getProperty("user.dir");
		String FILENAME = workingDir+"\\data\\config.txt";
		
		LinkedList<String> ll = new LinkedList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
		{

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) 
			{
				//get the path
				ll.add(workingDir+"\\data\\"+sCurrentLine);				
			}
		

		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return ll;

	}
	
	public void main(String[] args) throws Throwable 
	{
		Cancellation Cancel = new Cancellation();
		Booking Book = new Booking();
		
		availablelist= taxi.data.VehicleInfo.main(null);
		
		scanner = new Scanner(System.in);

		byte choice=0;
		
		//Main Menu
		taxi.data.Display.main(0);
		taxi.data.Display.main(1);
		
		try {
			//accepts the choice from user
			choice=scanner.nextByte();
		} catch (Exception e) 
		{
			taxi.data.Display.main(0);
			taxi.data.Display.main(5);
			taxi.data.Display.main(6);
		}
		
		switch (choice)
		{
		case 1 :
			{
			Book.main(null);
			break;
			}
			
		case 2 : 
			{
				Cancel.main(null);
				break;
			}

		case 3 :
			{
			taxi.data.Display.main(0);
			taxi.data.Display.main(4);
			taxi.data.Display.main(6);			
		    break;
			}
		default:
		{
			taxi.data.Display.main(0);
			taxi.data.Display.main(5);
			taxi.data.Display.main(6);
			break;
		}
		}

	}

}
