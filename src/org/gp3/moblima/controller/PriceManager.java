package org.gp3.moblima.controller;

import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.TicketPrice;

import java.util.ArrayList;

public class PriceManager {
    private static PriceManager singleInstance = new PriceManager();
    private ArrayList priceDB;

    private PriceManager() {
        Manager manager = Manager.getInstance();
        this.priceDB = manager.getAll(Constant.Tables.TICKETPRICE);
    }

    public static PriceManager getInstance() {
        return singleInstance;
    }


    public static Double getPrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean snack) {
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_THU && !snack)
                return TicketPrice.price[29];
            else
                return 38;
        } else {
            if (movietype == Constant.MovieType.TWO_D && tickettype == Constant.TicketType.SENIOR)
                return 5;
            else if (tickettype == Constant.TicketType.SENIOR) {
                return -1;
            } else if (tickettype == Constant.TicketType.STUDENT) {
                if (movietype == Constant.MovieType.TWO_D)
                    return 7;
                else if (movietype == Constant.MovieType.THREE_D)
                    return 8;
                else
                    return -1;
            } else if (tickettype == Constant.TicketType.MON_THU) {
                if (movietype == Constant.MovieType.TWO_D)
                    return 9;
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM || movietype == Constant.MovieType.THREE_D_AND_WESTMALL)
                    return 16;
                else
                    return 14;
            } else {
                if (getMovietype() == Constant.MovieType.TWO_D)
                    return 13;
                else if (getMovietype() == Constant.MovieType.THREE_D_AND_JEM || getMovietype() == Constant.MovieType.THREE_D_AND_WESTMALL)
                    return 16;
                else
                    return 14;
            }
        }
    }
}
