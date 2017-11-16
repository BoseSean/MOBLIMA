package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Review;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.printTitle;
import static org.gp3.moblima.view.IOUtil.read;
import static org.gp3.moblima.view.IOUtil.readInt;

/**
 * Menu to enable user to input the reviews and ratings towards the movie
 */
public class ReviewsMenu extends BaseMenu {
    private final Movie movie;

    public ReviewsMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    /**
     * Ask user to input reviews and ratings
     * @return return the movie infor menu
     */

    @Override
    public BaseMenu execute() {
        printTitle(movie.getTitle());

		Review review = new Review(read("Please Enter your comment for " + movie.getTitle() + ": ")  , readInt("Please enter your rating for " + movie.getTitle() ,1,5));

		movie.addReview(review);

		return this.getPreviousMenu();
	}
}
