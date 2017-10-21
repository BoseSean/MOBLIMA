package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

public class ListMovieTopRate extends BaseMenu {
    public ListMovieTopRate(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        Manager manager = Manager.getInstance();
        ArrayList<Movie> movies =  manager.getAll("MOVIE");

        ArrayList<String> choices = new ArrayList<>();

        try {

            sortRating(movies);

            int top = 1;

            for (Movie movie : movies) {
                choices.add(movie.getTitle());
                System.out.println(movie.getOverAllRating() + "Rating" + movie.getTitle());

                if (top++ == 5) {
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        choices.add("Movie Info");
        choices.add("Shop Top 5 by rating");
        choices.add("Back to all movies");

        int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

        BaseMenu nextMenu = this;

        if (c < choices.size()) {
            nextMenu = new MovieInfo(this, movies.get(c));
        } else if (c == choices.size()) {
            nextMenu = new ListMovieTopSale(this.getPreviousMenu());
        } else if (c == choices.size() + 1) {
            nextMenu = this.getPreviousMenu();
        }

        return nextMenu;

    }

    private void sortRating(ArrayList<Movie> movies) {
		Collections.sort(movies, new Comparator<Movie>() {
			@Override
			public int compare(Movie m1, Movie m2) {
				return Double.compare(m1.getOverAllRating(), m2.getOverAllRating());
			}
		});
    }

}
