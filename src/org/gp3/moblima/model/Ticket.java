package org.gp3.moblima.model;
import org.gp3.moblima.model.Constant.TicketType;
import org.gp3.moblima.model.Constant.MovieType;

/**
 * Created by hannancao on 14/10/17.
 */

public class Ticket extends Model{

    private double price;
    private TicketType tickettype;
    private MovieType movietype;
    private boolean platinum;
    private Seat seat;

    private Booking booking;

    public Ticket(boolean platium, MovieType movietype, TicketType tickettype, Seat seat){
        this.platinum = platium;
        this.movietype = movietype;
        this.tickettype = tickettype;
        this.seat = seat;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPlatium() {
        return platinum;
    }

    public void setPlatium(boolean platium) {
        this.platinum = platinum;
    }

    public MovieType getMovietype() {
        return movietype;
    }

    public void setMovietype(MovieType movietype) {
        this.movietype = movietype;
    }

    public TicketType getTickettype() {
        return tickettype;
    }

    public void setTickettype(TicketType tickettype) {
        this.tickettype = tickettype;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket t = (Ticket) obj;
            return (t.platinum == platinum && t.movietype ==movietype && t.tickettype == tickettype);
        }
        return super.equals(obj);
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
