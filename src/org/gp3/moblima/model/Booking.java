package org.gp3.moblima.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Shen Youlin on 14/10/17.
 */

public class Booking implements Model
{
    private String TID;
    private Date timestamp;
    private double totalPrice;
    private Movie movie;
    private Cinema cinema;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    private User user;
    private Slot slot;

    /**
     * Booking CLass constructor
     * @param tid unique tid
     * @param timestamp current booking time
     * @param totalPrice totalprice for all tickets
     * @param movie movie info
     * @param cinema cinema info
     * @param tickets tickets along with booking
     */
    public Booking(String tid, Slot slot, Date timestamp, double totalPrice, Movie movie, Cinema cinema, ArrayList<Ticket> tickets) {
        this.TID = tid;
        this.slot = slot;
        this.timestamp = timestamp;
        this.totalPrice = totalPrice;
        this.movie = movie;
        this.cinema = cinema;
        this.tickets = tickets;
    }



    /**
     * Get Ticket ID
     * @return TID of booking
     */
	public String getTID() {
        return TID;
    }

    /**
     * set TID of booking
     * @param TID TID of current booking
     */
    public void setTID(String TID) {
        this.TID = TID;
    }

    /**
     * Get the show date of the movie in this booking
     * @return date of show movie
     */
    public String getDate() {
        return this.slot.getFormattedDate();
    }

    /**
     * Get the show time of the movie in this booking
     * @return show time of movie
     */
    public String getTime() {
        return this.slot.getFormattedTime();
    }


    /**
     * Get the current booking time
     * @return timestamp to indicate booking time
     */
    public String getTimestamp() {
        return Constant.datetimeFormat.format(timestamp);
    }

    /**
     * Get total price of the booking
     * @return totalprice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Set total price of the booking
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Get the movie in instance of booking
     * @return Movie with all info
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Set a movie for a instance of booking
     * @param movie
     */
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
