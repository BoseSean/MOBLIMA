package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Review;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.printTitle;
import static org.gp3.moblima.view.IOUtil.read;
import static org.gp3.moblima.view.IOUtil.readInt;

public class ReviewsMenu extends BaseMenu {
    private final Movie movie;

    public ReviewsMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
        printTitle(movie.getTitle());

		Review review = new Review(read("Please Enter your comment for " + movie.getTitle() + ": ")  , readInt("Please enter your rating (1-5) for " + movie.getTitle() + " : "));

		movie.addReview(review);
		return this.getPreviousMenu();
	}
}
