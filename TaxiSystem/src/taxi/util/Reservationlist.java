package taxi.util;

import java.util.LinkedList;

public class Reservationlist {

	private static LinkedList<String> reserved = new LinkedList<String>();
	private static LinkedList<String> reservedlist = new LinkedList<String>();
	private static LinkedList<String> cancelled = new LinkedList<String>();
	
	public Reservationlist() {
	}

	public static void main(String[] args) 
	{
		reserved.add("\tReservation Details \n");
		cancelled.add("\r\n\tCancellation Details \n");
	}

	public static LinkedList<String> getreserved() {
		return reserved;
	}

	public static void setreserved(String[] reserveddetails) 
	{
		int Seq=reserved.size()+1000001; 
		String Sequence = Integer.toString(Seq);
		
		String VehicleNumber=reserveddetails[1];
		String Type=reserveddetails[2];
		String Date=reserveddetails[3].replace("-", "");
		String Time=reserveddetails[6].replace("-", "");
		
		//ReservationNumber
		String ReservationNumber = Sequence+Type+Date+Time+":"+VehicleNumber;
		
		reserved.add(ReservationNumber);
	}


	public static LinkedList<String> getreservedlist() {
		return reservedlist;
	}

	public static void setreservedlist(String[] reserveddetails) 
	{
		String VehicleNumber=reserveddetails[1];
		String Date=reserveddetails[3].replace("-", "");
		String FromTime=reserveddetails[6].replace("-", "");
		String ToTime=reserveddetails[7].replace("-", "");
		
		//ReservationNumber
		String details = VehicleNumber+Date+FromTime+ToTime;
		
		reservedlist.add(details);
	}

	
	public static LinkedList<String> getcancelled() {
		return cancelled;
	}

	public static void setcancelled(String cancelleddetails) {
		cancelled.add(cancelleddetails);
	}

}
