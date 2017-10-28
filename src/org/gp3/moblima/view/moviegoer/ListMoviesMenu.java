package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.view.Quit;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class ListMoviesMenu extends BaseMenu {

    public ListMoviesMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Movie Listing");
		Manager mg = Manager.getInstance();


		ArrayList<String> choices = new ArrayList<>();
        ArrayList<Movie> movies = mg.getAll(Constant.Tables.MOVIE);
        for (Movie m : movies) {
            choices.add(m.getTitle());
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
