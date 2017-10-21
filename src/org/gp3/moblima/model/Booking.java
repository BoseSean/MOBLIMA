package org.gp3.moblima.model;

import java.util.ArrayList;

/**
 * Created by Shen Youlin on 14/10/17.
 */

public class Booking extends Model
{
    private String TID,date;
    private double totalPrice;
    private Movie movie;
    private Cinema cinema;
    private ArrayList<Ticket>tickets;

    public Booking(String tid, String date, double totalPrice, Movie movie, Cinema cinema, ArrayList<Ticket> tickets) {
        TID = tid;
        this.date = date;
        this.totalPrice = totalPrice;
        this.movie = movie;
        this.cinema = cinema;
        this.tickets = new ArrayList<>();
    }


    public void getInfo() {
		System.out.println(this.getTID());
		System.out.println(this.getDate());
		System.out.println(this.getTotalPrice());
		System.out.println(this.getCinema().getName());
		System.out.println(this.getMovie().getTitle());
	}

	public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void addTickets(ArrayList<Ticket> new_tickets) {
        tickets = new_tickets;
        for (Ticket t : new_tickets)
        {
            this.totalPrice += t.getPrice();
        }

    }

    public void removeTickets(Seat seat) {
        for(Ticket t : tickets)
        {
            if(t.getSeat() == seat)
            {
                totalPrice -= t.getPrice();
                tickets.remove(t);
            }
        }
    }

}
