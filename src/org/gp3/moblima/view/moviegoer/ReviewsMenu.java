package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import static org.gp3.moblima.view.IOUtil.printTitle;

public class ReviewsMenu extends BaseMenu {
    private final Movie movie;

    public ReviewsMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
        printTitle(movie.getTitle());

        return null;
    }
}
