package org.gp3.moblima.view.admin;


import org.gp3.moblima.controller.PriceManager;
import org.gp3.moblima.model.Constant.MovieType;
import org.gp3.moblima.model.Constant.TicketType;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to configure price
 */
public class ConfigurePriceMenu extends BaseMenu {
    private PriceManager priceManager = PriceManager.getInstance();


    public ConfigurePriceMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    /**
     * Display configure price menu
     * Ask user to choice the type of ticket to change price
     * and bring user back to configure menu.
     *
     * @return configure menu
     */

    @Override
    public BaseMenu execute() {
        printTitle("Configure Price Menu");

        priceManager = PriceManager.getInstance();
        boolean toUpdatePlatinum = false;
        boolean toSneakOrFirstWeekorblockbuster = false;
        MovieType movieTypeToChange;
        TicketType ticketTypeToChange;
        ArrayList<String> choices = new ArrayList<>();

        println("Do you want to change ticket price for Platinum or Not Platinum?");
        println();
        choices.add("Platinum");
        choices.add("Not Platinum");
        printMenuItems(choices, 0);
        int c = readChoice(0, choices.size());
        switch (c) {
            case 0:
                toUpdatePlatinum = true;
                break;
            case 1:
                toUpdatePlatinum = false;
                break;
        }

        choices.clear();
        println("Do you want to change ticket price for Blockbuster or Not Blockbuster?");
        println();
        choices.add("Sneak or First Week or blockbuster");
        choices.add("Not Sneak not First Week not blockbuster");
        printMenuItems(choices, 0);
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
        printMenuItems(choices, 0);
        c = readChoice(0, choices.size());
        movieTypeToChange = MovieType.values()[c];

        println("What kind of ticket to change price?");
        choices.clear();
        for (TicketType type : TicketType.values()){
            choices.add(type.toString());
        }
        printMenuItems(choices, 0);
        c = readChoice(0, choices.size());
        ticketTypeToChange = TicketType.values()[c];

        int newPrice = readInt("New price: ");
        priceManager.updatePrice(ticketTypeToChange, movieTypeToChange, toUpdatePlatinum, toSneakOrFirstWeekorblockbuster, newPrice);
        println("Update Successful");
        return this.getPreviousMenu();
    }
}
