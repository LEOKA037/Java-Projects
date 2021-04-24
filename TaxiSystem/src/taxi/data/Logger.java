package taxi.data;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import taxi.main.TaxiReservation;
import taxi.util.Reservationlist;

public class Logger {

	public static void main(String[] args) 
	{
		TaxiReservation Main= new TaxiReservation();
		LinkedList<String> l1=Main.getConfigFile(null);
		
		LinkedList<String> reservedlist = Reservationlist.getreserved();
		LinkedList<String> cancelledlist = Reservationlist.getcancelled();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy, hh:mm");
		DateFormat df1 = new SimpleDateFormat("ddMMyyyyhhmm");
        Date currentDate = new Date();
        String today = df.format(currentDate);
        String today1= df1.format(currentDate);
        
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		//log file path
		String FILENAME = l1.get(1)+today1+".txt";
		
        // Log Header
        try {

        	String content ="\t Application Log \r\nDate and Time: "+today+"\r\n";
			fw = new FileWriter(FILENAME,true);
			bw = new BufferedWriter(fw);
			bw.write(content);
			
			
        }
        catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
        
        //Reservation Log
       
        int Rsize =reservedlist.size();
	      
	      for(int i=0;i<Rsize;i++)
        {
        	try {

        	String Search=(String) reservedlist.get(i);
		    String contentR ="\r\n"+Search ;
			fw = new FileWriter(FILENAME,true);
			bw = new BufferedWriter(fw);
			bw.write(contentR);
			
			
        }
        catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
	      
	      // Cancellation Log
	      int Csize =cancelledlist.size();
	      
	      for(int i=0;i<Csize;i++)	
        	try {

        	String Search=(String) cancelledlist.get(i);
		    String contentC="\r\n"+Search ;
			fw = new FileWriter(FILENAME,true);
			bw = new BufferedWriter(fw);
			bw.write(contentC);
			
			
        }
        catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
	}

