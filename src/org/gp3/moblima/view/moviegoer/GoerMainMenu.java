package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.printMenuItems;
import static org.gp3.moblima.view.IOUtil.printTitle;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class GoerMainMenu extends BaseMenu {
    public GoerMainMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Welcome to MOvie Booking and LIsting Management Application (MOBLIMA)");

        ArrayList<String> choices = new ArrayList<>();
        choices.add("Search For Movies");
        choices.add("All Movies");
        choices.add("History");
        printMenuItems(choices, 0);


        int c = readChoice();

        BaseMenu nextMenu = this;
        switch (c) {
            case 0:
                nextMenu = new SearchMovieMenu(this);
                break;
            case 1:
                nextMenu = new ListMoviesMenu(this);
                break;
            case 2:
                nextMenu = new HistoryMenu(this);
                break;
            case 3:
                nextMenu = this.getPreviousMenu();
                break;
        }
        return nextMenu;

    }
}
