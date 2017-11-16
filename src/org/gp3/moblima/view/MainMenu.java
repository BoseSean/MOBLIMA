package org.gp3.moblima.view;

//import org.gp3.moblima.view.IOUtil.*;

import org.gp3.moblima.view.admin.StaffLoginMenu;
import org.gp3.moblima.view.moviegoer.GoerMainMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * The main menu for all users
 */
public class MainMenu extends BaseMenu {

    public MainMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    /**
     * Display
     * * Consists of two menus:
     * 1. Administrator main menu
     * 2. Moviegoer main menu
     *
     * @return corresponding menu that the user has selected
     */
    @Override
    public BaseMenu execute() {

        printTitle("Welcome to MOvie Booking and LIsting Management Application (MOBLIMA)");

        ArrayList<String> choices = new ArrayList<>();
        choices.add("Administrator");
        choices.add("Customer");
        choices.add("Quit");
        printMenuItems(choices, 0);

        int c = readChoice(0, choices.size());

        BaseMenu nextMenu = this;
        switch (c) {
            case 0:
                nextMenu = new StaffLoginMenu(this);
                break;
            case 1:
                nextMenu = new GoerMainMenu(this);
                break;
            case 2:
                nextMenu = new Quit(this);
                break;
        }
        return nextMenu;
    }
}
