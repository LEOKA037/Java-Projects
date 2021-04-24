package taxi.util;
import java.util.LinkedList;

public class ReservationUtil extends Bookcab {

	//method to compare date
	int comparedate(String AvailableFrom,String AvailableTo,String Date) 
	{	
		if(AvailableFrom.compareTo(Date) <=0 && AvailableTo.compareTo(Date) >=0)
		{
			return 1;
		}
		else
		return 0;
	}
	
	//method to compare time
	int comparetime(String Time1,String Time2) 
	{		
		//greater will return 1 Time1 greater than Time 2
		String Time01 = Time1.replace("-", "");
		String Time02 = Time2.replace("-", "");
		
		int Hour1 = Integer.parseInt(Time01.substring(0,2));
		int Minute1 = Integer.parseInt(Time01.substring(2,4));
		int Hour2 = Integer.parseInt(Time02.substring(0,2));
		int Minute2 = Integer.parseInt(Time02.substring(2,4));
		
		if(Hour1>Hour2)
		{
			return 1 ;
		}
		else if (Hour1==Hour2)
		{
			if(Minute1>=Minute2)
			{
				return 1;
			}
			else if(Minute1==Minute2)
			{
				return 0;
			}
			else
				return 0;
		}
		else
			return 0;
		

	}
	
	//method to get the cab code
	String getCabtypecode(String Type) 
	{		
		String Type1="CAR";
		
		if(Type=="Hatchback") 
		{
			Type1="HB";			
		}
			
		else if(Type=="SEDAN") 
		{
			Type1="SD";			
		}
		else if(Type=="Luxury")  
		{
			Type1="LX";			
		} 
		else if(Type=="Innova") 
		{
			Type1="IN";			
		}
		else if(Type=="Tavera") 
		{
			Type1="TV";			
		}

		return Type1;
	}
	
	//method to check the reserved list
	int checkreservedlist(String CabNumber,String Date) 
	{
		LinkedList<String> reservedlist = Reservationlist.getreserved();
		
		int size =reservedlist.size();
		int c=0;
	      
	      for(int i=1;i<size;i++)
	      {
	    	  String Search=(String) reservedlist.get(i);
	    	  String VehicleNumber = Search.substring(24,34);
	    	  String BookedDate = Search.substring(9,17);
	    	  int checkV=VehicleNumber.compareTo(CabNumber);
	    	  int checkD=BookedDate.compareTo(Date.replace("-", ""));
	    	 
	    	  if(checkV==0 && checkD==0)
	    	  {
	    		  c=1;
	    		  break;
	    	  }
	    	  else
	    	  {
	    		  continue;
	    	  }
	      }		
		return c;
	}

	//method to check reserved car's available slot
	int checkavailableslots(String[] reserveddetails)
	{
		ReservationUtil checkcab = new ReservationUtil();
		
		String CabNumber=reserveddetails[1];
		String Date=reserveddetails[3];
		String FromTime=reserveddetails[6];
		String ToTime=reserveddetails[7];
		
		LinkedList<String> reservedlist = Reservationlist.getreservedlist();
		
		int size =reservedlist.size();
		int c=0;
	      
	      for(int i=0;i<size;i++)
	      {
	    	  String Search=(String) reservedlist.get(i);
	    	  String VehicleNumber = Search.substring(0,10);
	    	  String BookedDate = Search.substring(10,18);
	    	  int checkV=VehicleNumber.compareTo(CabNumber);
	    	  int checkD=BookedDate.compareTo(Date.replace("-", ""));
	    	  
	    	  if(checkV==0 && checkD==0)
	    	  {
	    		  String BookedFrom = Search.substring(18,24);
	    		  String BookedTo = Search.substring(24,30);
		    	  
		    	  int check01 = checkcab.comparetime(BookedFrom,FromTime); //
		    	  int check02 = checkcab.comparetime(BookedFrom,ToTime); //
		    	  int check03 = checkcab.comparetime(BookedTo,FromTime); //
		    	  int check04 = checkcab.comparetime(BookedTo,ToTime); //
	    		  
	    		  int check1=BookedFrom.compareTo(ToTime); //0
	    		  int check2=BookedTo.compareTo(FromTime); //0
	    		  
	    		  if(check01==1)
	    		  {
	    			  if(check02==1||check1==0)
	    			  {
	    				  //slot available before the booked from time
	    				  c++; 
	    			  }
	    			  else
	    			  {
	    				  c=0;
	    				  break;
	    			  }
	    		  }
	    		  else
	    		  {
	    			  if(check03!=1||check2==0)
	    			  {
	    				  if(check04!=1)
	    				  {
	    					//slot available after the booked to time
	    					c++;   
	    				  }
	    				  else
	    				  {
	    					  c=0;
		    				  break;
	    				  }
	    					
	    			  }
	    			  else
	    			  {
	    				  c=0;
	    				  break;
	    			  }
	    		  }
	    	  }
	    	  else
	    	  {
	    		  continue;
	    	  }
	      }
	      
	      if(c==0)
	      {
	    	  return 1;
	      }
	      else
	    	  return 0; //cab available
		
	}
	
	//method to convert string to date
	String StringToDate(String DateString) {
		
		String Day = DateString.substring(0,2);
		String Month = DateString.substring(2,4);
		String Year = DateString.substring(4,8);
		
		String Date = Year+"-"+Month+"-"+Day;
		return Date;

	}
	
	public static void main(String[] details,String Type1) throws Throwable 
	 	{
		ReservationUtil checkcab = new ReservationUtil();
		
		String Date=details[1];		
		String Time=details[2];		
		String FromTime=details[3];		
		String ToTime=details[4];
		
		int counter =0;
		
		LinkedList<String> reservedlist = Reservationlist.getreserved();
		
		String reserveddetails[] = new String[8];
		reserveddetails[1]=null;
		reserveddetails[2]=null;
		reserveddetails[3]=null;
		reserveddetails[4]=null;
		reserveddetails[5]=null;
		reserveddetails[6]=null;
		reserveddetails[7]=null;
		
		String Type=checkcab.getCabtypecode(Type1);
			
		int size =availablelist.size();
	      
	      for(int i=0;i<size;i++)
	      {
	    	  String Search=(String) availablelist.get(i);
	    	  int Length= Search.length();
	    	  String CarType =Search .substring(0, Length-39);
	    	  int TypeLength= CarType.length();

	    	  String AvailableFromDate= Search.substring(TypeLength+12, TypeLength+20);
	    	  String AvailableToDate= Search.substring(TypeLength+21, TypeLength+29 );
	    	  String DailyFromTime= Search.substring(TypeLength+30, TypeLength+34 );
	    	  String DailyToTime= Search.substring(TypeLength+35, TypeLength+39 );
	    	  String VehicleNumber= Search.substring(TypeLength+1, TypeLength+11);
	    	  
	    	  String AvailableFrom=checkcab.StringToDate(AvailableFromDate);
	    	  String AvailableTo=checkcab.StringToDate(AvailableToDate);
	    	  
	    	  //availablity checks
	    	  int check01 = checkcab.comparetime(DailyFromTime,FromTime); //DailyFromTime<FromTime return 0
	    	  int check02 = checkcab.comparetime(DailyFromTime,ToTime); //DailyFromTime<ToTime return 0
	    	  int check03 = checkcab.comparetime(DailyToTime,FromTime); //DailyToTime>FromTime return 1
	    	  int check04 = checkcab.comparetime(DailyToTime,ToTime); // DailyToTime>ToTime return 1
	    	  int check05 = checkcab.comparetime(FromTime,ToTime); // FromTime < ToTime return 0
	    	  int check06 = checkcab.comparedate(AvailableFrom, AvailableTo, Date); // return 1	    	  
	    	  int check07 = CarType.compareTo(Type1);
	    	  int check08 = checkcab.checkreservedlist(VehicleNumber,Date);
	    	  int check = 1;
	    	  
	    	  if(DailyFromTime.compareTo((FromTime.replace("-", "")).substring(0,4))==0)
	    	  {
	    		check01=0;
	    	  }
	    	  
	    	  if(check01==0 && check02==0 && check03==1 && check04==1 && check05==0 && check06==1 && check07==0)
	    	  {      	  
	    	  if (check08!=0)
	    	  {
	    		  reserveddetails[1]=VehicleNumber;
	    		  reserveddetails[2]=Type;
	    		  reserveddetails[3]=Date;
	    		  reserveddetails[4]=Time;
	    		  reserveddetails[6]=FromTime;
	    		  reserveddetails[7]=ToTime;
	    		 
	    		  check=checkcab.checkavailableslots(reserveddetails);	    		  
	    	  }
	    	  }
	    	  if(check==0){
	    		  check08=0;
	    	  }

	    	  
	    	  //Reservering the Available Cab
	    	  if((check01==0) && (check02==0) && (check03==1) && (check04==1) && check05==0 && check06==1 && check07==0 && check08==0)
	    	  {  		  
	    		//reservation details
	    		  reserveddetails[1]=VehicleNumber;
	    		  reserveddetails[2]=Type;
	    		  reserveddetails[3]=Date;
	    		  reserveddetails[4]=Time;
	    		  reserveddetails[6]=FromTime;
	    		  reserveddetails[7]=ToTime;
	    		 
	    		// adding the reserved details to reservedlist
	    		  Reservationlist.setreserved(reserveddetails);
	    		  Reservationlist.setreservedlist(reserveddetails); 
	    		 
	    		  String Reservation=(String) reservedlist.get(reservedlist.size()-1);
	    		  
	    		  reserveddetails[5]=Reservation.substring(0,23); //Reservation number
	    		  
	    		  
	    		// taxi.data.print the details of confirmed cab
	    		  taxi.data.Display.main(15,reserveddetails);     		  
	    		  counter++;
		    	  break;	    		 
	    	  } 
	    	  else 
	    	  {
	    		  continue;
	    	  }
 	      }
	      if(counter==0)
	      {
	    	  reserveddetails[2]=Type;
    		  reserveddetails[3]=Date;
    		  reserveddetails[4]=Time;
	    	  taxi.data.Display.main(16,reserveddetails);  
	      }
	}
}