package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by hannancao on 14/11/17.
 */

public class StaffTopFiveByRate extends BaseMenu {

        public StaffTopFiveByRate(BaseMenu previousMenu) {
            super(previousMenu);
        }

        @Override
        public BaseMenu execute() {
            Manager manager = Manager.getInstance();
            ArrayList<Movie> movies =  manager.getAll(Constant.Tables.MOVIE);
            printTitle("Top 5 by Rating");
            ArrayList<String> choices = new ArrayList<>();

            try {

                sortRating(movies);
                int top = 1;
                for (Movie movie : movies) {
                    choices.add("Update info for " + movie.getTitle());
                    if (top++ == 5) {
                        break;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }


            choices.add("Shop Top 5 by sales");
            choices.add("Back to Staff Menu");

            printMenuItems(choices, 0);

            int c = readChoice(0, choices.size());

            BaseMenu nextMenu = this;

            if (c <= choices.size() - 3) {
                nextMenu = new UpdateMovieMenu(this, movies.get(c));
            } else if (c == choices.size() - 2) {
                nextMenu = new StaffTopFiveBySale(this.getPreviousMenu());
            } else if (c == choices.size() - 1) {
                nextMenu = this.getPreviousMenu();
            }

            return nextMenu;

        }

        private void sortRating(ArrayList<Movie> movies) {
            Collections.sort(movies, new Comparator<Movie>() {
                @Override
                public int compare(Movie m1, Movie m2) {
                    return Double.compare(m2.getOverAllRating(), m1.getOverAllRating());
                }
            });
        }

}
