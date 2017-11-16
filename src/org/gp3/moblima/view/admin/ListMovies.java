package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.model.Constant.Tables.MOVIE;
import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to list all movies
 */
public class ListMovies extends BaseMenu {
	public ListMovies(BaseMenu previousMenu) {
		super(previousMenu);
	}

	/**
	 * Display all movies
	 * Ask user to choice which movie to configure
	 * and bring user to next stage of application
	 * Consist of four menu
	 * 1. Show Top 5 movies by sales
	 * 2. Show Top 5 movies by rating
	 * 3. Back to previous menu
	 * 4. Quit
	 *
	 * @return return to the corresponding menu that the user has selected
	 */
	@Override
	public BaseMenu execute() {
		printTitle("List Movies");

		Manager manager = Manager.getInstance();
		ArrayList<Movie> movies = manager.getAll(MOVIE);

		ArrayList<String> choices = new ArrayList<>();

		for (Movie movie : movies) {
			choices.add("Update info for " + movie.getTitle());
		}

		choices.add("Show Top 5 by sale");
		choices.add("Shop Top 5 by rating");
		choices.add("Back");

		printMenuItems(choices, 0);

		int c = readChoice(0, choices.size());

		BaseMenu nextMenu = this;
		if (c < movies.size()) {
			nextMenu = new UpdateMovieMenu(this, movies.get(c));
		} else if (c == movies.size())
			nextMenu = new StaffTopFiveBySale(this.getPreviousMenu());
		else if (c == movies.size() + 1)
			nextMenu = new StaffTopFiveByRate(this.getPreviousMenu());
		else if (c == movies.size() + 2)
			nextMenu = this.getPreviousMenu();
		return nextMenu;
	}
}
