package org.gp3.moblima.model;

import org.gp3.moblima.model.Constant.MovieType;
import org.gp3.moblima.model.Constant.TicketType;
/**
 * Created by hannancao on 6/11/17.
 */
public class TicketPrice{
    private static Double[] price;
    private TicketType tickettype;
    private MovieType movietype;
    private boolean platinum;
    private boolean snack;

    public TicketPrice(){}
    public TicketPrice(boolean platium, MovieType movietype, TicketType tickettype, boolean snack){
        price = new Double[]{5.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 7.0, 8.0, -1.0, -1.0, -1.0, -1.0, -1.0, 9.0, 14.0, 14.0, 14.0, 16.0, 14.0, 16.0, 13.0, 14.0, 14.0, 14.0, 16.0, 14.0, 16.0, 28.0, 38.0};
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

    public boolean isPlatinum() {
        return platinum;
    }

    public boolean isSnack() {
        return snack;
    }

    public void setSnack(boolean snack) {
        snack = snack;
    }

    public void setTickettype(TicketType tickettype) {
        this.tickettype = tickettype;
    }

    public void setMovietype(MovieType movietype) {
        this.movietype = movietype;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }

    public static Double[] getPrice() {
        return price;
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
