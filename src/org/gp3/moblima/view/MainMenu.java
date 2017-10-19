package org.gp3.moblima.view;

import org.gp3.moblima.view.IOUtil.readChoice;
import org.gp3.moblima.view.admin.StaffLogin;
import org.gp3.moblima.view.moviegoer.GoerMainMenu;

import java.util.ArrayList;

/**
 * created by hannancao on 15/10/17.
 */
public class MainMenu extends BaseMenu{

    public MainMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Welcome to MOvie Booking and LIsting Management Application (MOBLIMA)");

        ArrayList<String> choices = new ArrayList<>();
        choices.add("Administrator");
        choices.add("Customer");
        choices.add("Quit");
        printMenuItems("Use as:", choices, 0);

        int c = readChoice();

        switch (c) {
            case 0:
                return new StaffLogin(this);
            break;
            case 1:
                return new GoerMainMenu(this);
            break;
            case 2:
                return new Quit(this);
            break;
        }
        return this;
    }
}
