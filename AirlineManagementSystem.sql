# Create a database for the Airline Management System
create database airlinemanagementsystem;

# Use the database
use airlinemanagementsystem;

# Create first table for login credentials inside the airlinemanagementsystem database;
create table login(username varchar(20), password varchar(20));

# Insert default value in the login table for the admin to login
insert into login values('admin', 'admin');

# Create second table to store passenger details;
create table passenger (name varchar(20), nationality varchar(20), phone varchar(15), address varchar(50), cust_id varchar(20), gender varchar(20));

# Create table to store flights' information
create table flight(f_code varchar(20), f_name varchar(20), src varchar(40), destination varchar(40));

# Insert some flights into the flight table
insert into flight values("1001", "AI-1212", "Delhi", "Mumbai");
insert into flight values("1002", "AI-1453", "Delhi", "Goa");
insert into flight values("1003", "AI-1112", "Mumbai", "Chennai");
insert into flight values("1004", "AI-3222", "Delhi", "Amritsar");
insert into flight values("1005", "AI-1212", "Delhi", "Ayodhya");


# Create reservation table to store ticket booking information
create table reservation(PNR varchar(15), TICKET varchar(20), aadhar varchar(20), name varchar(20), nationality varchar(30), flightname varchar(15), flightcode varchar(20), src varchar(30), des varchar(30), ddate varchar(30));

# Create table cancel to store cancelled tickets' information
create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), ddate varchar(30));

-- DDL commands
show tables;
select * from login;
select * from passenger;
describe flight;
select * from flight;
select * from reservation;
select * from cancel;

-- For manual changes
# SET SQL_SAFE_UPDATES = 0;
# SET SQL_SAFE_UPDATES = 1;