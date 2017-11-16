package org.gp3.moblima.controller;

import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Holiday;
import org.gp3.moblima.model.Slot;
import org.gp3.moblima.model.TicketPrice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * The price manager class to manage all the information towarding to discount stuffs
 */

public class PriceManager {
    private static PriceManager singleInstance = new PriceManager();
    private static TicketPrice ticketPrice;

    private PriceManager() {
        Manager manager = Manager.getInstance();
        if (manager.getAll(Constant.Tables.TICKETPRICE).isEmpty())
            manager.add(Constant.Tables.TICKETPRICE, new TicketPrice());
        ticketPrice = (TicketPrice) manager.getAll(Constant.Tables.TICKETPRICE).get(0);
    }

    public static PriceManager getInstance() {
        return singleInstance;
    }
    /**
     * Get the responding price from the TicketPrice Array
     * according to movie type, ticket type,
     * platium, seank, first week and blockbuster
     * @param tickettype Type of the ticket
     * @param movietype Type of the movie
     * @param platinum boolean variable indicate whether it is platium
     * @param SneakOrFirstWeekorblockbuster boolean variable indicate whether it is platium or seank or first week or blockbuster
     * @return The price value of the required ticket type, movie type
     */
    public Double getPrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean SneakOrFirstWeekorblockbuster) {
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_TO_THU && !SneakOrFirstWeekorblockbuster)
                return ticketPrice.getPrice(28);
            else
                return ticketPrice.getPrice(29);
        }
        else {
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
            } else if (tickettype == Constant.TicketType.MON_TO_THU) {
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
    /**
     * Update the responding price from the TicketPrice Array
     * according to movie type, ticket type,
     * platium, seank, first week and blockbuster
     * @param tickettype Type of the ticket
     * @param movietype Type of the movie
     * @param platinum boolean variable indicate whether it is platium
     * @param SneakOrFirstWeekorblockbuster boolean variable indicate whether it is platium or seank or first week or blockbuster
     * @param price the new price
     */
    public void updatePrice(Constant.TicketType tickettype, Constant.MovieType movietype, boolean platinum, boolean SneakOrFirstWeekorblockbuster, double price) {
        if (platinum) {
            if (tickettype == Constant.TicketType.MON_TO_THU && !SneakOrFirstWeekorblockbuster)
                ticketPrice.updatePrice(28, price);
            else
                ticketPrice.updatePrice(29, price);
        } else {
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
            } else if (tickettype == Constant.TicketType.MON_TO_THU) {
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
    /**
     * Return the corresponding ticket type from the enum in Constant,
     * based on the show time of the movie, movie type,
     * and whether it is student or senior ticket
     * @param showtime the movie showing time according to the slot
     * @param isStudent boolean variable to indicate whether the ticket is student
     * @param isSeniorCitizen boolean variable to indicate whether the ticket is senior
     * @return the corresponding ticket type from the enum in Constant
     */
    public Constant.TicketType getTicketType(Slot showtime, boolean isStudent, boolean isSeniorCitizen) {
        try {
            Manager manager = Manager.getInstance();
            Calendar cal = Calendar.getInstance();
            cal.setTime(showtime.getDate());
            Date six = Constant.clockFormat.parse("18:00");
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            // Sat, Sun, Eve of PH or PH
            boolean hol = false;
            ArrayList<Holiday> holidays = manager.getAll(Constant.Tables.HOLIDAY);
            for (Holiday holiday : holidays) {
                if (holiday.getDate().equals(showtime.getDate())) {
                    hol = true;
                    break;
                }
            }
            if (hol || (dayOfWeek >= Calendar.SATURDAY && dayOfWeek <= Calendar.SUNDAY)) {
                return Constant.TicketType.SAT_TO_SUN;
            }
            else {
                // Mon to Fri
                if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                    if (showtime.getTime().before(six)) {
                        if (isStudent) {
                            return Constant.TicketType.STUDENT;
                        }
                        else if (isSeniorCitizen) {
                            return Constant.TicketType.SENIOR;
                        }
                        else if (dayOfWeek == Calendar.FRIDAY) {
                            return Constant.TicketType.FRI_BEFORE_SIX_PM;
                        }
                        // Fri after 6pm
                    }
                    else if (dayOfWeek == Calendar.FRIDAY) {
                        return  Constant.TicketType.FRI_AFTER_SIX_PM;
                    }

                    // Mon to Thu
                    if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.THURSDAY) {
                        return  Constant.TicketType.MON_TO_THU;
                        // Fri
                    }
                    else if (dayOfWeek == Calendar.FRIDAY) {
                        return  Constant.TicketType.FRI;
                    }
                }
            }

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
