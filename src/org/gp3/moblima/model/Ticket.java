package org.gp3.moblima.model;
import org.gp3.moblima.model.Constant.TicketType;
import org.gp3.moblima.model.Constant.MovieType;

import java.util.ArrayList;

/**
 * Created by hannancao on 14/10/17.
 */

public class Ticket implements Model{

    private double price;
//    private TicketType tickettype;
//    private MovieType movietype;
//    private boolean platinum;
    private Seat seat;
//    private boolean Snack;
    private Booking booking;
    private TicketPrice ticketprice;

    //todo how to calculate ticket price?
    public Ticket(){}

    public Ticket(Seat seat, Booking booking, TicketPrice ticketprice){
        this.seat = seat;
        this.booking = booking;
        this.ticketprice = ticketprice;
    }

    public TicketPrice getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(TicketPrice ticketprice) {
        this.ticketprice = ticketprice;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket t = (Ticket) obj;
            return (t.seat == seat && t.ticketprice == ticketprice);
        }
        return super.equals(obj);
    }

}
