package org.gp3.moblima.model;

import org.gp3.moblima.model.Constant.TicketType;
import org.gp3.moblima.model.Constant.MovieType;
/**
 * Created by hannancao on 6/11/17.
 */
public class TicketPrice{
    private double price;
    private TicketType tickettype;
    private MovieType movietype;
    private boolean platinum;
    private boolean snack;

    public TicketPrice(){}
    public TicketPrice(boolean platium, MovieType movietype, TicketType tickettype, boolean snack){
        this.platinum = platium;
        this.movietype = movietype;
        this.tickettype = tickettype;
        this.snack = snack;
    }
    public TicketType getTickettype() {
        return tickettype;
    }

    public MovieType getMovietype() {
        return movietype;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public boolean isSnack() {
        return snack;
    }

    public void setSnack(boolean snack) {
        snack = snack;
    }

    public void setTickettype(Constant.TicketType tickettype) {
        this.tickettype = tickettype;
    }

    public void setMovietype(Constant.MovieType movietype) {
        this.movietype = movietype;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculatePrice(){
        if(platinum){
            if(getTickettype() == TicketType.MON_THU && !snack)
                return 28;
            else
                return 38;
        }
        else{
            if(getMovietype() == MovieType.TWO_D && getTickettype() == TicketType.SENIOR)
                return 5;
            else if(getTickettype() == TicketType.SENIOR){
                return -1;
            }
            else if(getTickettype() == TicketType.STUDENT){
                if(getMovietype() == MovieType.TWO_D)
                    return 7;
                else if(getMovietype() == MovieType.THREE_D)
                    return 8;
                else
                    return -1;
            }
            else if(getTickettype() == TicketType.MON_THU){
                if(getMovietype() == MovieType.TWO_D)
                    return 9;
                else if(getMovietype() == MovieType.THREE_D_AND_JEM || getMovietype() == MovieType.THREE_D_AND_WESTMALL)
                    return 16;
                else
                    return 14;
            }
            else{
                if(getMovietype() == MovieType.TWO_D)
                    return 13;
                else if(getMovietype() == MovieType.THREE_D_AND_JEM || getMovietype() == MovieType.THREE_D_AND_WESTMALL)
                    return 16;
                else
                    return 14;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TicketPrice) {
            TicketPrice t = (TicketPrice) obj;
            return (t.platinum == platinum && t.movietype == movietype && t.tickettype == tickettype && t.snack == snack);
        }
        return super.equals(obj);
    }
}
