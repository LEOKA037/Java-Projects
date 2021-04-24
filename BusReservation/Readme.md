# Bus Reservation Java REST API
REST APIs for Bus Reservations Developed using Java

This was done during 2020 as a part of my interview with Paypal. The project was approved and was selected for next round with Paypal.


The below are the API details with the URL, parameters and sample responses.

#### Search REST API
---------------
URL
POST request
http://localhost:8081/api/search

PARAMETERS
```json
{
    "busName": "Bus01",
    "departureDate": "2020-07-02T04:30:00.176+00:00",
    "returnDate": "2020-07-03T04:30:00.176+00:00",
    "sourceCity": "S1",
    "destinationCity": "D1"
}
```
returnDate is optional.

Will return the List of Buses.
First Set is "To Destination" Bus list,
Then if return date is avaiable,
Second Set is "From Destination" Bus List

#### Bus Details REST API
--------------------
URL
GET request
http://localhost:8081/api/bus/{busName}

PARAMETERS
busName=Bus01

returns the list of Bus all the details like
busName,duration,availableSeats,bookedSeats,sourceCity,destinationCity,departureDate,arrivalDate

availableSeats- can be used to display the seats in green in UI and booked Seats in red.

#### Book REST API
--------------------
URL
POST request
http://localhost:8081/api/bookBus?seatNumber={seatNumber}&busName={busName}&userName={userName}

PARAMETERS
seatNumber=d5
busName=Bus01
userName=user2

return the Invoice details and also updates the Bus avaiable and booked seats.
Invoice will have busName,operator,departureDate,sourceCity,destinationCity,duration,price,userName,email



Vist for more info: [leo.ka](https://leoka1993.wixsite.com/leoka)

#### Social Media Links
- Mail: leo.ka1993@gmail.com
- Linkden : [Leo KA](http://linkedin.com/in/leoka037)
- Instagram : [Leo__037](https://instagram.com/leo____037)
- Facebook : [Leo KA](http://www.facebook.com/LEO.K.A.037)
- Pinterest : [Leo KA](www.in.pinterest.com/leoka1993/)
