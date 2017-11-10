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
        boolean toSneakOrFirstWeekorblockbuster = false;
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
        choices.add("Sneak or First Week or blockbuster");
        choices.add("Not Sneak not First Week not blockbuster");
        c = readChoice(0, choices.size());
        switch (c) {
            case 0:
                toSneakOrFirstWeekorblockbuster = true;
                break;
            case 1:
                toSneakOrFirstWeekorblockbuster = false;
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
        PriceManager.updatePrice(ticketTypeToChange, movieTypeToChange, toUpdatePlatinum, toSneakOrFirstWeekorblockbuster, newPrice);
        return this.getPreviousMenu();
    }
}
