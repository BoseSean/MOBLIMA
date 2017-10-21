package org.gp3.moblima.view.admin;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

public class UpdateMovieMenu extends BaseMenu {

    private Movie movie;
    public UpdateMovieMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
        return null;
    }
}
