package org.gp3.moblima.view;

//import org.gp3.moblima.view.IOUtil.*;
import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Admin;
import org.gp3.moblima.view.admin.StaffLoginMenu;
import org.gp3.moblima.view.moviegoer.GoerMainMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.printMenuItems;
import static org.gp3.moblima.view.IOUtil.printTitle;
import static org.gp3.moblima.view.IOUtil.readChoice;

/**
 * created by hannancao on 15/10/17.
 */
public class MainMenu extends BaseMenu {

    public MainMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {

/*
        Manager manager = Manager.getInstance();
		Admin admin = new Admin();
		admin.setUsername("ADMIN");
		admin.setPassword("ADMIN");
		manager.add("ADMIN", admin);
*/

		printTitle("Welcome to MOvie Booking and LIsting Management Application (MOBLIMA)");

        ArrayList<String> choices = new ArrayList<>();
        choices.add("Administrator");
        choices.add("Customer");
        choices.add("Quit");
        printMenuItems(choices, 0);

        int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

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
