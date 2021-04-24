package com.example.BusReservation.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BusReservation.model.Bus;
import com.example.BusReservation.model.Invoice;
import com.example.BusReservation.model.Search;
import com.example.BusReservation.model.Ticket;
import com.example.BusReservation.model.User;
import com.example.BusReservation.repository.BusRepository;
import com.example.BusReservation.repository.TicketRepository;
import com.example.BusReservation.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class RestApi {

	@Autowired
	 private BusRepository busRepository;
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	 private TicketRepository ticketRepository;
	
	 public RestApi() {
		
	}
	
	@PostMapping("/bus")
    public Bus createEmployee(@RequestBody Bus bus) {		
        return busRepository.save(bus);
    }
	
	@GetMapping("/bus")
    public List <Bus> getAllBusDetails() {
		
        return (List<Bus>) busRepository.findAll();
    }
	
	@GetMapping("/searchBus")
    public List <Bus> findBySearchParameters() throws ParseException {
		
		String departureDate = "2020-07-02 10:00";
	    Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(departureDate);  	
        return (List<Bus>) busRepository.findBySearchParameters(date1, 
        		"S1", "D1");
    }
	
	@GetMapping("/user")
    public List <User> getAllUserDetails() {		
        return (List<User>) userRepository.findAll();
    }
	
	@GetMapping("/tickets")
    public List <Ticket> getAllTicketDetails() {		
        return (List<Ticket>) ticketRepository.findAll();
    }
	
	/*
	 * http://localhost:8081/api/bus/Bus01
	 */
	@GetMapping("/bus/{busName}")
    public Bus findByBusName(@PathVariable String busName) {		
        return busRepository.findByBusName(busName);
    }
	
	@PostMapping("/bookBus")
    public Invoice bookTicket(@RequestParam(required = true) String busName,
    		@RequestParam(required = false) String seatNumber,
    		@RequestParam(required = true) String userName) throws ParseException {	
		
		Invoice invoice = new Invoice();
		
		Date reservationDate = new Date();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		String strDate = dateFormat.format(reservationDate); 
		Date reservationDateFormatted =new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(strDate);
		
		String ticketNumber = "Ticket"+strDate+seatNumber;
		
		Bus bus = busRepository.findByBusName(busName);
		User user = userRepository.findByUserName(userName);
		
		String avaiableSeats = bus.getAvailableSeats().replace(","+seatNumber, "");
		String bookedSeats = bus.getBookedSeats()+","+seatNumber;
		
		bus.setBookedSeats(bookedSeats);
		bus.setAvailableSeats(avaiableSeats);
		
		busRepository.save(bus);
		
		Ticket ticket = new Ticket();
		
		ticket.setBus(bus);
		ticket.setUser(user);
		ticket.setReservationDate(reservationDateFormatted);
		ticket.setSeatNumber(seatNumber);
		ticket.setTicketNumber(ticketNumber);
		
		ticketRepository.save(ticket);
		
		invoice.setBusName(busName);
		invoice.setDepartureDate(bus.getDepartureDate());
		invoice.setDestinationCity(bus.getDestinationCity());
		invoice.setDuration(bus.getDuration());
		invoice.setEmail(user.getEmail());
		invoice.setOperator(bus.getOperator());
		invoice.setPrice(bus.getPrice());
		invoice.setSourceCity(bus.getSourceCity());
		invoice.setUserName(userName);
		
        return invoice;
    }

	/*
	 * [
    {
        "busName": "Bus01",
        "duration": 5,
        "availableSeats": "d1,d2,d3,d4,d5",
        "bookedSeats": "d6",
        "sourceCity": "S1",
        "destinationCity": "D1",
        "departureDate": "2020-07-02 04:30",
        "arrivalDate": "2020-07-01 04:30"
    }
]
	 */
	
	@PostMapping("/api/employees")
	public Ticket saveTicket(@RequestBody Search search) {
		Ticket ticket = new Ticket();
		return null;
	}	
	
	
	@PostMapping("/search")
	public List<Bus> saveEmployee(@RequestBody Search search) throws ParseException{
	System.out.println(search.getBusName()+" "+search.getDestinationCity()
	  										+" "+search.getSourceCity()
	  										+" "+search.getDepartureDate()
	  										+" "+search.getReturnDate());
	  
	
	  System.out.println(search.getDepartureDate().toString());
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	  String strDate = dateFormat.format(search.getDepartureDate()); 
	  Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(strDate);
	  System.out.println(date1);
	  
	  //"departureDate": "2020-07-02T04:30:00.176+00:00",
	  //--> Thu Jul 02 10:00:00 IST 2020 -- "2020-07-02 10:00"
	  
	  List<Bus> searchResult = new LinkedList<Bus>();
	  
	  searchResult = (List<Bus>) busRepository.findBySearchParameters(date1,
			  search.getSourceCity(), search.getDestinationCity());
	  
	  if(!(search.getReturnDate() == null || search.getReturnDate().toString().isEmpty())) {
		  
		  strDate = dateFormat.format(search.getReturnDate()); 
		  date1=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(strDate);
		  
		  searchResult.addAll((List<Bus>) busRepository.findBySearchParameters(date1,
				  search.getDestinationCity(),search.getSourceCity()));
	  }
	  
	  return searchResult;
	 }
	
	

}
