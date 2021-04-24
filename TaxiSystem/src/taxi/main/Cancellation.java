package taxi.main;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import taxi.util.Reservationlist;

public class Cancellation {
	public static Scanner scanner;
	
	//method to check reservation number in reserved list
	String reservationnumbercheck(String ReservationNumber1) 
	{
		LinkedList<String> reservedlist = Reservationlist.getreserved();
		
		String ReservationNumber = null ;
		String Reserveddetail="CAR";
		int counter=0;
		int size =reservedlist.size();
	      
	      for(int i=1;i<size;i++)
	      {
	    	  String Search=(String) reservedlist.get(i);
	    	  ReservationNumber = Search.substring(0,23);
	    	  int Check=ReservationNumber1.compareTo(ReservationNumber);
	    	  if(Check==0)
	    	  {	    		  
	    		  Reserveddetail = Search;
	    		  counter++;
	    		  break;
	    	  }
	    	  else{
	    		  continue;
	    	  }
	      }
		
	      if(counter==0)
	      {
	    	  return null;  
	      }
	      else {
	      return Reserveddetail;
	      }

	}

	//method to validate the entered reservation number
	int reservationnumberValidate(String ReservationNumber) 
	{
		TaxiReservation Main= new TaxiReservation();
		int datechecker=0;
		int timechecker=0;
		
		if(ReservationNumber.length()<23)
		{
			 return 0;
		}
		
		String SeqNumber=ReservationNumber.substring(0,7);
		String CabType= ReservationNumber.substring(7,9);
		String Day = ReservationNumber.substring(15,17);
		String Month = ReservationNumber.substring(13,15);
		String Year = ReservationNumber.substring(9,13);
		String Hour = ReservationNumber.substring(17,19);
		String Minute = ReservationNumber.substring(19,21);
		String Seconds = ReservationNumber.substring(21,23);
		
		String Date = Year+"-"+Month+"-"+Day;
		String Time = Hour+"-"+Minute+"-"+Seconds;
		String pattern = "(^(\\d+))"; //sequence number should be interger
		String pattern1 = "([HSLIT][BDXNV])"; //Cab Type Code as per Businness Rules
		Pattern r = Pattern.compile(pattern);
		Pattern r1 = Pattern.compile(pattern1);
		 
		 Matcher d = r.matcher(SeqNumber);
		 Matcher d1 = r1.matcher(CabType);
	     if (d.find( )) 
	     {
	    	 if (d1.find( )) 
	    	 {	    		 
	    		 datechecker=Main.isValidDate(Date);
	    		 timechecker=Main.isValidTime(Time);
	    		 	    	 
	    		 if(timechecker==1 && datechecker==1)
	    			 return 1;
	    		 else
	    			 return 0;
	    	 }
	    	 else 
	    	 {		    	 
		    	  return 0;
	    	 }
	    	 
	      }
	     else {
	    	  return 0;
	   	      }
	}
	
	//main
	public void main(String[] args) throws Throwable {
		
		Cancellation Cancellation=new Cancellation();
		
		TaxiReservation MainMenu= new TaxiReservation();
				
		scanner = new Scanner(System.in);
		String Previous="9";
		String ReservationNumber = "";
		
		taxi.data.Display.main(0);
		taxi.data.Display.main(3);
		taxi.data.Display.main(7);		
		
		try {
			ReservationNumber = scanner.nextLine();
		} catch (Exception e) 
		{
			taxi.data.Display.main(0);
			taxi.data.Display.main(5);
			taxi.data.Display.main(6);
		}

		int Check=ReservationNumber.compareTo(Previous);
		
	     if(Check==0)
		{
			MainMenu.main(null);		
		}
	     else
	     {
	    	 int Check1=Cancellation.reservationnumberValidate(ReservationNumber);
	    	 if(Check1==1)
	    	 {
	    		 String Reserveddetail=Cancellation.reservationnumbercheck(ReservationNumber);
	    		 if(Reserveddetail!=null)
	    		 {
	    			//cab details available
	    			 String CabNumber = Reserveddetail.substring(23,32);
	    			 
	    			 //add cancelled detail to cancellist
	    			 Reservationlist.setcancelled(Reserveddetail);
	    			 
	    			 taxi.data.Display.main(14,CabNumber,ReservationNumber); 
	    		 }
	    		 else 
	    		 {
	    			 taxi.data.Display.main(18,ReservationNumber); 
	    		 }
	    		 
	    	 }
	    	 else
	    	 {
	    		 taxi.data.Display.main(17,ReservationNumber);
	    	 }
	     }
	}

}
