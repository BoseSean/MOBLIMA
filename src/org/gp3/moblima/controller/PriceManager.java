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
                return TicketPrice.getPrice()[28];
            else
                return TicketPrice.getPrice()[29];
        } else {
            if (tickettype == Constant.TicketType.SENIOR) {
                if (movietype == Constant.MovieType.TWO_D)
                    return TicketPrice.getPrice()[0];
                else if (movietype == Constant.MovieType.THREE_D)
                    return TicketPrice.getPrice()[1];
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return TicketPrice.getPrice()[2];
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return TicketPrice.getPrice()[3];
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return TicketPrice.getPrice()[4];
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return TicketPrice.getPrice()[5];
                else
                    return TicketPrice.getPrice()[6];
            } else if (tickettype == Constant.TicketType.STUDENT) {
                if (movietype == Constant.MovieType.TWO_D)
                    return TicketPrice.getPrice()[7];
                else if (movietype == Constant.MovieType.THREE_D)
                    return TicketPrice.getPrice()[8];
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return TicketPrice.getPrice()[9];
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return TicketPrice.getPrice()[10];
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return TicketPrice.getPrice()[11];
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return TicketPrice.getPrice()[12];
                else
                    return TicketPrice.getPrice()[13];
            } else if (tickettype == Constant.TicketType.MON_THU) {
                if (movietype == Constant.MovieType.TWO_D)
                    return TicketPrice.getPrice()[14];
                else if (movietype == Constant.MovieType.THREE_D)
                    return TicketPrice.getPrice()[15];
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return TicketPrice.getPrice()[16];
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return TicketPrice.getPrice()[17];
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return TicketPrice.getPrice()[18];
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return TicketPrice.getPrice()[19];
                else
                    return TicketPrice.getPrice()[20];
            } else if (tickettype == Constant.TicketType.FIR_SUN_AND_PH) {
                if (movietype == Constant.MovieType.TWO_D)
                    return TicketPrice.getPrice()[21];
                else if (movietype == Constant.MovieType.THREE_D)
                    return TicketPrice.getPrice()[22];
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return TicketPrice.getPrice()[23];
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return TicketPrice.getPrice()[24];
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return TicketPrice.getPrice()[25];
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return TicketPrice.getPrice()[26];
                else
                    return TicketPrice.getPrice()[27];
            }
        }
    }
}
