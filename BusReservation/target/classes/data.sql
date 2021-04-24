insert into BUS_DETAILS
(BUS_ID,ARRIVAL_DATE,AVAILABLE_SEATS,BOOKED_SEATS,BUS_NAME,operator,duration,price,DEPARTURE_DATE,DESTINATION_CITY,SOURCE_CITY)
values(101,'2020-07-01 10:00','d1,d2,d3,d4,d5','d6','Bus01','Bus01operator',5,100,'2020-07-02 10:00','D1','S1');

insert into BUS_DETAILS
(BUS_ID,ARRIVAL_DATE,AVAILABLE_SEATS,BOOKED_SEATS,BUS_NAME,operator,duration,price,DEPARTURE_DATE,DESTINATION_CITY,SOURCE_CITY)
values(102,'2020-07-01 10:00','d1,d2,d3,d4,d5','d6','Bus02','Bus02operator',5,100,'2020-07-02 10:00','D2','S2');

insert into BUS_DETAILS
(BUS_ID,ARRIVAL_DATE,AVAILABLE_SEATS,BOOKED_SEATS,BUS_NAME,operator,duration,price,DEPARTURE_DATE,DESTINATION_CITY,SOURCE_CITY)
values(103,'2020-07-04 10:00','d1,d2,d3,d4,d5','d6,d7','Bus03','Bus03operator',5,100,'2020-07-03 10:00','S1','D1');

insert into BUS_DETAILS
(BUS_ID,ARRIVAL_DATE,AVAILABLE_SEATS,BOOKED_SEATS,BUS_NAME,operator,duration,price,DEPARTURE_DATE,DESTINATION_CITY,SOURCE_CITY)
values(104,'2020-07-01 10:00','d1,d2,d3,d4,d5','d6','Bus04','Bus04operator',5,100,'2020-07-02 10:00','D1','S1');

insert into USER_DETAILS 
(USER_ID,EMAIL,PASSWORD,USER_NAME)
values(101,'email1@sample','password','user1');

insert into USER_DETAILS 
(USER_ID,EMAIL,PASSWORD,USER_NAME)
values(102,'email2@sample','password','user2');
  
insert into TICKET_DETAILS
(ID,BUS_ID,seat_Number,ticket_Number,RESERVATION_DATE,USER_ID)
values(103,101,'d1','Tckt01','2020-06-01 10:00',101);

insert into TICKET_DETAILS
(ID,BUS_ID,seat_Number,ticket_Number,RESERVATION_DATE,USER_ID)
values(104,102,'d2','Tckt02','2020-06-01 10:00',102);

