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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
