package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;
import java.util.Collections;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to display top 5 movie sort by sale
 */
public class StaffTopFiveBySale extends BaseMenu {
    public StaffTopFiveBySale(BaseMenu previousMenu) {
        super(previousMenu);
    }

    /**
     * Display movie sort by sales
     * Ask user which movie to configure
     *
     * @return corresponding menu that the user has selected
     */
    @Override
    public BaseMenu execute() {
        Manager manager = Manager.getInstance();
        ArrayList<Movie> movies = manager.getAll(Constant.Tables.MOVIE);
        printTitle("Top 5 by Sales");
        ArrayList<String> choices = new ArrayList<>();

        try {

            sortTicketSales(movies);

            int top = 1;
            for (Movie movie : movies) {
                if(movie.getShowingStatus() != Constant.ShowingStatus.END_SHOWING && movie.getShowingStatus() != Constant.ShowingStatus.COMING_SOON)
                {
                    choices.add("Update info for " + movie.getTitle());
                    if (top++ == 5) {
                        break;
                    }
                }

            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        choices.add("Shop Top 5 by rating");
        choices.add("Back to Staff Menu");
        printMenuItems(choices, 0);

        int c = readChoice(0, choices.size());

        BaseMenu nextMenu = this;


        if (c <= choices.size() - 3) {
            nextMenu = new UpdateMovieMenu(this, movies.get(c));
        } else if (c == choices.size() - 2) {
            nextMenu = new StaffTopFiveByRate(this.getPreviousMenu());
        } else if (c == choices.size() - 1) {
            nextMenu = this.getPreviousMenu();
        }

        return nextMenu;

    }

    private void sortTicketSales(ArrayList<Movie> movies) {
        Collections.sort(movies, (m1, m2) -> (m1.getTicketSales() - m2.getTicketSales()));
    }
}
