package org.gp3.moblima.controller;

import org.gp3.moblima.model.*;

import java.util.ArrayList;

/**
 * Created by zhangxinye on 14/10/17.
 */
class SerializeDB {

    ArrayList<Admin> admins;
    ArrayList<Booking> bookings;
    ArrayList<Cinema> cinemas;
    ArrayList<Movie> movies;
    ArrayList<Seat> seats;
    ArrayList<Ticket> tickets;
    ArrayList<User> users;
    ArrayList<Review> reviews;
	ArrayList<Holiday> holidays;
	SerializeDB(){
        admins = new ArrayList<>();
        admins.add(new Admin("admin","admin"));
        bookings = new ArrayList<>();
        cinemas = new ArrayList<>();
        movies = new ArrayList<>();
		movies.add(new Movie("Matrix"));
		movies.add(new Movie("Matrix2"));
		seats = new ArrayList<>();
        tickets = new ArrayList<>();
        users = new ArrayList<>();
        reviews = new ArrayList<>();
		holidays = new ArrayList<>();
	}

}
