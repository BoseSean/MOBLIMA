package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.controller.PriceManager;
import org.gp3.moblima.model.Holiday;
import org.gp3.moblima.model.TicketPrice;
import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.model.Constant.TicketType;
import org.gp3.moblima.model.Constant.MovieType;
import org.gp3.moblima.model.Ticket;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.gp3.moblima.model.Constant.Tables.HOLIDAY;

import static org.gp3.moblima.model.Constant.Tables.TICKET;
import static org.gp3.moblima.view.IOUtil.*;
import static org.gp3.moblima.view.IOUtil.println;

public class ConfigurePriceMenu extends BaseMenu {
    private PriceManager priceManager;


    public ConfigurePriceMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        // TODO by DAXIONGDI
        printTitle("Configure Price Menu");

        priceManager = PriceManager.getInstance();
        boolean toUpdatePlatinum;
        boolean toUpdateSnake;
        MovieType movieTypeToChanhge;
        TicketType ticketTypeToChange;
        ArrayList<String> choices = new ArrayList<String>();

        println("Do you want to change ticket price for Platinum or Not Platinum?");
        choices.add("Platinum");
        choices.add("Not Platinum");
        int c = readChoice(0, choices.size());
        switch (c) {
            case 0: toUpdatePlatinum=true;break;
            case 1: toUpdatePlatinum=false;break;
        }

        println("Do you want to change ticket price for Snake or No Snake?");
        choices.clear();
        choices.add("Snake");
        choices.add("No Snake");
        c = readChoice(0, choices.size());
        switch (c) {
            case 0: toUpdateSnake=true;break;
            case 1: toUpdateSnake=false;break;
        }

        println("What kind of movie to change price?");
        choices.clear();
        for (MovieType type : MovieType.values()){
            choices.add(type.toString());
        }
        c = readChoice(0, choices.size());
        movieTypeToChanhge = MovieType.values()[c];

        println("What kind of ticket to change price?");
        choices.clear();
        for (TicketType type : TicketType.values()){
            choices.add(type.toString());
        }
        c = readChoice(0, choices.size());
        ticketTypeToChange = TicketType.values()[c];



        return this.getPreviousMenu();
    }

    private void updatePrice(){
        String name = read("Input Ticket type");

    }

}
