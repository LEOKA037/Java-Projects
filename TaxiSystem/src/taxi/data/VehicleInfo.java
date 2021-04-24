package taxi.data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import taxi.main.TaxiReservation;

public class VehicleInfo {	
	
	public static LinkedList<String> main(String[] ags) 
	{	
		
		TaxiReservation Main= new TaxiReservation();
		LinkedList<String> l1=Main.getConfigFile(null);
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//Path of the Information File 
		String FILENAME = l1.get(0)+".txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
		{

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) 
			{
				ll.add(sCurrentLine);				
			}
		

		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return ll;

	}

}
