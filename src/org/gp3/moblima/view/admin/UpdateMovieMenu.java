package org.gp3.moblima.view.admin;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

public class UpdateMovieMenu extends BaseMenu {

    private Movie movie;
    public UpdateMovieMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
    	printTitle("Update Movie Info Menu");
		ArrayList<String> choices = new ArrayList<>();

		choices.add("Update Title");
		choices.add("Update Director");
		choices.add("Update Opening Time");
		choices.add("Update Runtime");
		choices.add("Update Synopsis");
		choices.add("Back");

		int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

		BaseMenu nextMenu = this;

		switch (c) {
			case 1:
				String title = read("New Title: ");
				movie.setTitle(title);
				break;

			case 2:
				String director = read("New Director: ");
				movie.setDirector(director);
				break;
			case 3:
				String opening = read("New Opening Time: ");
				movie.setOpening(opening);
				break;
			case 4:
				String synopsis = read("New Synopsis");
				movie.setSynopsis(synopsis);
				break;
			default:
				break;
		}

		return null;
    }
}
