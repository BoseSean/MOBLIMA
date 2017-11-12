package org.gp3.moblima.controller;

import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.TicketPrice;


public class PriceManager {
    private static PriceManager singleInstance = new PriceManager();
    private static TicketPrice ticketPrice;

    private PriceManager() {
        Manager manager = Manager.getInstance();
        ticketPrice = (TicketPrice) manager.getAll(Constant.Tables.TICKETPRICE).get(0);
    }

    public static PriceManager getInstance() {
        return singleInstance;
    }

    public Double getPrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean SneakOrFirstWeekorblockbuster) {
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_THU && !SneakOrFirstWeekorblockbuster)
                return ticketPrice.getPrice(28);
            else
                return ticketPrice.getPrice(29);
        } else {
            if (tickettype == Constant.TicketType.SENIOR) {
                if (movietype == Constant.MovieType.TWO_D)
                    return ticketPrice.getPrice(0);
                else if (movietype == Constant.MovieType.THREE_D)
                    return ticketPrice.getPrice(1);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return ticketPrice.getPrice(2);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return ticketPrice.getPrice(3);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return ticketPrice.getPrice(4);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return ticketPrice.getPrice(5);
                else
                    return ticketPrice.getPrice(6);
            } else if (tickettype == Constant.TicketType.STUDENT) {
                if (movietype == Constant.MovieType.TWO_D)
                    return ticketPrice.getPrice(7);
                else if (movietype.equals(Constant.MovieType.THREE_D))
                    return ticketPrice.getPrice(8);
                else if (movietype.equals(Constant.MovieType.DOLBY_AUTO))
                    return ticketPrice.getPrice(9);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return ticketPrice.getPrice(10);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return ticketPrice.getPrice(11);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return ticketPrice.getPrice(12);
                else
                    return ticketPrice.getPrice(13);
            } else if (tickettype == Constant.TicketType.MON_THU) {
                if (movietype == Constant.MovieType.TWO_D)
                    return ticketPrice.getPrice(14);
                else if (movietype == Constant.MovieType.THREE_D)
                    return ticketPrice.getPrice(15);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return ticketPrice.getPrice(16);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return ticketPrice.getPrice(17);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return ticketPrice.getPrice(18);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return ticketPrice.getPrice(19);
                else
                    return ticketPrice.getPrice(20);
            } else {
                if (movietype == Constant.MovieType.TWO_D)
                    return ticketPrice.getPrice(21);
                else if (movietype == Constant.MovieType.THREE_D)
                    return ticketPrice.getPrice(22);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    return ticketPrice.getPrice(23);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    return ticketPrice.getPrice(24);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    return ticketPrice.getPrice(25);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    return ticketPrice.getPrice(26);
                else
                    return ticketPrice.getPrice(27);
            }
        }
    }

    public void updatePrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean SneakOrFirstWeekorblockbuster, double price) {
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_THU && !SneakOrFirstWeekorblockbuster)
                ticketPrice.updatePrice(28, price);
            else
                ticketPrice.updatePrice(29, price);
        }
        else{
            if (tickettype == Constant.TicketType.SENIOR) {
                if (movietype == Constant.MovieType.TWO_D)
                    ticketPrice.updatePrice(0, price);
                else if (movietype == Constant.MovieType.THREE_D)
                    ticketPrice.updatePrice(1, price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    ticketPrice.updatePrice(2, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    ticketPrice.updatePrice(3, price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    ticketPrice.updatePrice(4, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    ticketPrice.updatePrice(5, price);
                else
                    ticketPrice.updatePrice(6, price);
            } else if (tickettype == Constant.TicketType.STUDENT) {
                if (movietype == Constant.MovieType.TWO_D)
                    ticketPrice.updatePrice(7, price);
                else if (movietype == Constant.MovieType.THREE_D)
                    ticketPrice.updatePrice(8, price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    ticketPrice.updatePrice(9, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    ticketPrice.updatePrice(10, price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    ticketPrice.updatePrice(11, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    ticketPrice.updatePrice(12, price);
                else
                    ticketPrice.updatePrice(13, price);
            } else if (tickettype == Constant.TicketType.MON_THU) {
                if (movietype == Constant.MovieType.TWO_D)
                    ticketPrice.updatePrice(14, price);
                else if (movietype == Constant.MovieType.THREE_D)
                    ticketPrice.updatePrice(15, price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    ticketPrice.updatePrice(16, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    ticketPrice.updatePrice(17, price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    ticketPrice.updatePrice(18, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    ticketPrice.updatePrice(19, price);
                else
                    ticketPrice.updatePrice(20, price);
            } else {
                if (movietype == Constant.MovieType.TWO_D)
                    ticketPrice.updatePrice(21, price);
                else if (movietype == Constant.MovieType.THREE_D)
                    ticketPrice.updatePrice(22, price);
                else if (movietype == Constant.MovieType.DOLBY_AUTO)
                    ticketPrice.updatePrice(23, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_JEM)
                    ticketPrice.updatePrice(24, price);
                else if (movietype == Constant.MovieType.THREE_D_AND_JEM)
                    ticketPrice.updatePrice(25, price);
                else if (movietype == Constant.MovieType.TWO_D_AND_WESTMALL)
                    ticketPrice.updatePrice(26, price);
                else
                    ticketPrice.updatePrice(27, price);
            }
        }
    }
}
