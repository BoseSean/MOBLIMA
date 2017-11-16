package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.view.Quit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to list all the movies
 */
public class ListMoviesMenu extends BaseMenu {

    public ListMoviesMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

	/**
	 * Display all movies
	 * Ask user to choice the next menu
	 * and bring user to next stage of application
	 * Consist of four menu
	 * 1. Show Top 5 movies by sales
	 * 2. Show Top 5 movies by rating
	 * 3. Back to previous menu
	 * 4. Quit Booking System
	 * @return return to the corresponding menu that the user has selected
	 */
	@Override
    public BaseMenu execute() {
        printTitle("Movie Listing");
		Manager mg = Manager.getInstance();


		ArrayList<String> choices = new ArrayList<>();
        ArrayList<Movie> movies = mg.getAll(Constant.Tables.MOVIE);
        for (Movie m : movies) {
			Date currentTime = Calendar.getInstance().getTime();
			if(m.getEnding().compareTo(currentTime) < 0) {
				m.setShowingStatus(Constant.ShowingStatus.END_SHOWING);
			}
			String title = m.getTitle() + (m.getShowingStatus().equals(Constant.ShowingStatus.END_SHOWING) ? " (End Showing)" : "");
			choices.add(title);
        }

        choices.add("Show Top 5 by sale");
        choices.add("Shop Top 5 by rating");
		choices.add("Back");
		choices.add("Quit");
		printMenuItems(choices, 0);

		int c = readChoice(0, choices.size());

		BaseMenu nextMenu = this;
		if (c < movies.size())
			nextMenu = new MovieInfo(this, movies.get(c));
		else if (c == movies.size())
			nextMenu = new ListMovieTopSale(this.getPreviousMenu());
		else if (c == movies.size() + 1)
			nextMenu = new ListMovieTopRate(this.getPreviousMenu());
		else if (c == movies.size() + 2)
			nextMenu = this.getPreviousMenu();
		else if (c == movies.size() + 3)
			nextMenu = new Quit(null);

		return nextMenu;
    }

}
