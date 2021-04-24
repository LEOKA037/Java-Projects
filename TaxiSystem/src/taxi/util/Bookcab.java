package taxi.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import taxi.main.Booking;

public class Bookcab extends Booking {
	
	//method to get car type
	String getcabtype(byte choice) {
		String Type="CAR";
		
		if(choice==1) 
		{
			Type="Hatchback";			
		}
			
		else if(choice==2) 
		{
			Type="SEDAN";			
		}
		else if(choice==3)  
		{
			Type="Luxury";			
		} 
		else if(choice==4) 
		{
			Type="Innova";			
		}
		else if(choice==5) 
		{
			Type="Tavera";			
		}
		return Type;
	}

	//method to get minimum journey date
	String getjourneydate(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		
		 Date currentDate = new Date();

	     Calendar c = Calendar.getInstance();
	     c.setTime(currentDate);

	      c.add(Calendar.DATE, 7);

	      Date currentDatePlusOne = c.getTime();
	      String reportDate = dateFormat.format(currentDatePlusOne);

		return reportDate;
	}
	
	public static void main(byte choice) throws Throwable  
	{												
		Bookcab bookcab= new Bookcab();
		String Type=bookcab.getcabtype(choice);
		
		
		String[] details = taxi.data.JourneyData.main(choice);	
		
		if(details!=null)
		{
			
			String date=details[1];
			String mindate1 = bookcab.getjourneydate(null);
			
			if((date.compareTo(mindate1))>=1)
			{
			taxi.util.ReservationUtil.main(details, Type);
			}
			else
			{
			taxi.data.Display.main(19);
			}
		}
		else
		{
			taxi.data.Display.main(11);
		}
				
	}

}
