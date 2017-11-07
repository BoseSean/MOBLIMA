package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Holiday;
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
import static org.gp3.moblima.model.Constant.Tables.PRICE;
import static org.gp3.moblima.model.Constant.Tables.TICKET;
import static org.gp3.moblima.view.IOUtil.*;
import static org.gp3.moblima.view.IOUtil.println;

public class ConfigurePriceMenu extends BaseMenu {

    public ConfigurePriceMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }


    @Override
    public BaseMenu execute() {
        // TODO by DAXIONGDI
        printTitle("Configure Price Menu");

        Manager manager = Manager.getInstance();

        ArrayList<String> choices = new ArrayList<String>();

        Ticket ticket = new Ticket();

        choices.add("Update Price");
        choices.add("Remove Price");
        choices.add("Add New Price");

        printMenuItems(choices, 0);

        int c = readChoice(0, choices.size());
        switch(c){
            case 0:
                String name = read("Input Ticket type");
                ticket = manager.getEntry(TICKET, (Ticket h) -> (h.equals(name));
                if(ticket != null) {
                    int price = readInt("Input Ticket price");
                }
                break;
            case 1:
                name = read("Input corresponding ticket type to be remove: ");
                ticket = manager.getEntry(TICKET, (Ticket h) -> (h.equals(name)));
                if (ticket != null) {
                    manager.delete(TICKET, ticket);
                } else {
                    println("Ticket type Does Not Exists");
                }
                break;
            case 2:
        }
        return this.getPreviousMenu();
    }
}
