package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Review;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class MovieInfo extends BaseMenu {
    private final Movie movie;
    public MovieInfo(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
        printTitle(movie.getTitle());

        printMovieInfo();

        ArrayList<String> choices = new ArrayList<>();
        choices.add("Buy Tickets");
        choices.add("Reviews");
        choices.add("Back");
        printMenuItems(choices, 0);


//        int c = readChoice();
        int c = readChoice(0, choices.size());

        BaseMenu nextMenu = this;
        switch (c) {
            case 0:
                nextMenu = new BuyTicketMenu(this, movie);
                break;
            case 1:
                nextMenu = new ReviewsMenu(this, movie);
                break;
            case 2:
                nextMenu = this.getPreviousMenu();
                break;
        }
        return nextMenu;
    }

    public void printMovieInfo() {
        println("Title: " + this.movie.getTitle());
        println("Rumtime: " + this.movie.getRuntime());
        println("Director: " + this.movie.getDirector());
        println("Opening: " + this.movie.getOpening());
        println("Synopsis: " + this.movie.getSynopsis());
        for (Review r : movie.getReview()) {
        	println("Review: " + r.getComment());
        }
        println("Overall Rating: " + this.movie.getOverAllRating());
    }
}
