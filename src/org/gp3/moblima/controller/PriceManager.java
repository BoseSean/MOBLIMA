package org.gp3.moblima.controller;

import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.TicketPrice;

import java.util.ArrayList;

public class PriceManager {
    private static PriceManager singleInstance = new PriceManager();
    private ArrayList priceDB;

    private PriceManager() {
        Manager manager = Manager.getInstance();
        //todo
        //this.priceDB = manager.getAll(Constant.Tables.TICKETPRICE);
    }

    public static PriceManager getInstance() {
        return singleInstance;
    }

    public static Double getPrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean SneakOrFirstWeekorblockbuster) {
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_THU && !SneakOrFirstWeekorblockbuster)
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
                else if (movietype.equals(Constant.MovieType.THREE_D))
                    return TicketPrice.getPrice()[8];
                else if (movietype.equals(Constant.MovieType.DOLBY_AUTO))
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
            } else {
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

    public static void updatePrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean SneakOrFirstWeekorblockbuster, double price){
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_THU && !SneakOrFirstWeekorblockbuster)
                TicketPrice.updatePrice(28 , price);
            else
                TicketPrice.updatePrice(29 , price);
        }
        else{
            if (tickettype == Constant.TicketType.SENIOR) {
                if (movietype == Constant.MovieType.TWO_D)
                    TicketPrice.updatePrice(0 , price);
                else if (movietype == Constant.MovieType.THREE_D)
                    TicketPrice.updatePrice(1 , price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    TicketPrice.updatePrice(2 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    TicketPrice.updatePrice(3 , price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    TicketPrice.updatePrice(4 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    TicketPrice.updatePrice(5 , price);
                else
                    TicketPrice.updatePrice(6 , price);
            } else if (tickettype == Constant.TicketType.STUDENT) {
                if (movietype == Constant.MovieType.TWO_D)
                    TicketPrice.updatePrice(7 , price);
                else if (movietype == Constant.MovieType.THREE_D)
                    TicketPrice.updatePrice(8 , price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    TicketPrice.updatePrice(9 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    TicketPrice.updatePrice(10 , price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    TicketPrice.updatePrice(11 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    TicketPrice.updatePrice(12 , price);
                else
                    TicketPrice.updatePrice(13 , price);
            } else if (tickettype == Constant.TicketType.MON_THU) {
                if (movietype == Constant.MovieType.TWO_D)
                    TicketPrice.updatePrice(14 , price);
                else if (movietype == Constant.MovieType.THREE_D)
                    TicketPrice.updatePrice(15 , price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    TicketPrice.updatePrice(16 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    TicketPrice.updatePrice(17 , price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    TicketPrice.updatePrice(18 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    TicketPrice.updatePrice(19 , price);
                else
                    TicketPrice.updatePrice(20 , price);
            } else {
                if (movietype == Constant.MovieType.TWO_D)
                    TicketPrice.updatePrice(21 , price);
                else if (movietype == Constant.MovieType.THREE_D)
                    TicketPrice.updatePrice(22 , price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    TicketPrice.updatePrice(23 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    TicketPrice.updatePrice(24 , price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    TicketPrice.updatePrice(25 , price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    TicketPrice.updatePrice(26 , price);
                else
                    TicketPrice.updatePrice(27 , price);
            }
        }
    }
}
