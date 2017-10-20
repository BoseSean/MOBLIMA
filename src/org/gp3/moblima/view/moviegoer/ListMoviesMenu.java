package org.gp3.moblima.view.moviegoer;

import java.util.ArrayList;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.view.Quit;

import static org.gp3.moblima.view.IOUtil.printMenuItems;
import static org.gp3.moblima.view.IOUtil.printTitle;
import static org.gp3.moblima.view.IOUtil.readChoice;

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
//		Manager mg = new Manager();

		ArrayList<String> choices = new ArrayList<>();
        choices.add("Movie Info");
        choices.add("Show Top 5 by sale");
        choices.add("Shop Top 5 by rating");
		choices.add("Quit");
		printMenuItems(choices, 0);

		int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

		BaseMenu nextMenu = this;
		switch (c) {
			case 0:
//				nextMenu = new MovieInfo(this, movie);
				break;
			case 1:
				nextMenu = new ListMovieTopSale(this);
				break;
			case 2:
				nextMenu = new ListMovieTopRate(this);
				break;
			case 3:
				nextMenu = this.getPreviousMenu();
				break;
		}
		return nextMenu;
    }

}
