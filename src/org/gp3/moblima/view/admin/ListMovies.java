package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import org.gp3.moblima.model.Constant.TableName;

import static org.gp3.moblima.view.IOUtil.*;

import java.util.ArrayList;

public class ListMovies extends BaseMenu {
    public ListMovies(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
		Manager manager = Manager.getInstance();
		ArrayList<Movie> movies = manager.getAll(TableName.MOVIE);

		ArrayList<String> choices = new ArrayList<>();

		for (Movie movie : movies) {
			choices.add("Update info for " + movie.getTitle());
		}

		choices.add("Back");

		printMenuItems(choices, 0);

		int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

		BaseMenu nextMenu = this;
		if (c < choices.size()) {
			nextMenu = new UpdateMovieMenu(this, movies.get(c));
		} else if (c == choices.size()) {
			nextMenu = this.getPreviousMenu();
		}

		return null;
    }
}
