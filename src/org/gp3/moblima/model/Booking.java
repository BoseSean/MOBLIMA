package org.gp3.moblima.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Shen Youlin on 14/10/17.
 */

public class Booking implements Model
{
    private String TID;
    private Date date;
    private double totalPrice;
    private Movie movie;
    private Cinema cinema;
    private ArrayList<Ticket>tickets;

    private User user;
    private Slot slot;

    /**
     * Booking CLass constructor
     * @param tid
     * @param date
     * @param totalPrice
     * @param movie
     * @param cinema
     * @param tickets
     */
    public Booking(String tid, Date date, double totalPrice, Movie movie, Cinema cinema, ArrayList<Ticket> tickets) {
        TID = tid;
        this.date = date;
        this.totalPrice = totalPrice;
        this.movie = movie;
        this.cinema = cinema;
        this.tickets = new ArrayList<>();
    }


    /**
     * Get Movie info
     */
    public void getInfo() {
		System.out.println(this.getTID());
		System.out.println(this.getDate());
		System.out.println(this.getTotalPrice());
		System.out.println(this.getCinema().getName());
		System.out.println(this.getMovie().getTitle());
	}

    /**
     * Get Ticket ID
     * @return
     */
	public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket new_ticket){
        if(tickets == null){
            this.tickets = new ArrayList<>();
            this.tickets.add(new_ticket);
        }
        else{
            this.tickets.add(new_ticket);
        }
        //totalPrice += new_ticket.getPrice();
    }

    public void removeTicket(Ticket new_ticket){
        for(int i = 0; i < this.tickets.size(); i++){
            if (this.tickets.get(i) == new_ticket) {
                this.tickets.remove(i);
                return;
            }
        }
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Booking) {
            Booking t = (Booking) obj;
            return (t.TID == TID && t.movie == movie && t.cinema == cinema);
        }
        return super.equals(obj);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
