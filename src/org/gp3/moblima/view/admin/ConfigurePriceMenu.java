package org.gp3.moblima.view.admin;


import org.gp3.moblima.controller.PriceManager;

import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.model.Constant.TicketType;
import org.gp3.moblima.model.Constant.MovieType;
import java.util.ArrayList;
import static org.gp3.moblima.view.IOUtil.*;
import static org.gp3.moblima.view.IOUtil.println;

public class ConfigurePriceMenu extends BaseMenu {
    private PriceManager priceManager;


    public ConfigurePriceMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Configure Price Menu");

        priceManager = PriceManager.getInstance();
        boolean toUpdatePlatinum = false;
        boolean toUpdateSnake = false;
        boolean toBlockbuster = false;
        boolean toFirstweek = false;
        MovieType movieTypeToChange;
        TicketType ticketTypeToChange;
        ArrayList<String> choices = new ArrayList<String>();

        println("Do you want to change ticket price for Platinum or Not Platinum?");
        choices.add("Platinum");
        choices.add("Not Platinum");
        int c = readChoice(0, choices.size());
        switch (c) {
            case 0:
                toUpdatePlatinum = true;
                break;
            case 1:
                toUpdatePlatinum = false;
                break;
        }

        println("Do you want to change ticket price for Blockbuster or Not Blockbuster?");
        choices.add("Blockbuster");
        choices.add("Not Blockbuster");
        c = readChoice(0, choices.size());
        switch (c) {
            case 0:
                toBlockbuster = true;
                break;
            case 1:
                toBlockbuster = false;
                break;
        }

        println("Do you want to change ticket price for Sneaks or No Sneaks?");
        choices.clear();
        choices.add("Sneaks");
        choices.add("No Sneaks");
        c = readChoice(0, choices.size());
        switch (c) {
            case 0:
                toUpdateSnake = true;
                break;
            case 1:
                toUpdateSnake = false;
                break;
        }

        println("Do you want to change ticket price for First Week show or No First Week show?");
        choices.clear();
        choices.add("FirstWeek");
        choices.add("No FirstWeek");
        c = readChoice(0, choices.size());
        switch (c) {
            case 0:
                toFirstweek = true;
                break;
            case 1:
                toFirstweek = false;
                break;
        }
        println("What kind of movie to change price?");
        choices.clear();
        for (MovieType type : MovieType.values()){
            choices.add(type.toString());
        }
        c = readChoice(0, choices.size());
        movieTypeToChange = MovieType.values()[c];

        println("What kind of ticket to change price?");
        choices.clear();
        for (TicketType type : TicketType.values()){
            choices.add(type.toString());
        }
        c = readChoice(0, choices.size());
        ticketTypeToChange = TicketType.values()[c];

        int newPrice = readInt("What kind of ticket to change price?");
        PriceManager.updatePrice(ticketTypeToChange, movieTypeToChange, toUpdatePlatinum, toUpdateSnake, newPrice, toBlockbuster, toFirstweek);
        return this.getPreviousMenu();
    }
}
