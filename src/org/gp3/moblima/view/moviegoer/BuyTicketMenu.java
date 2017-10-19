package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

public class BuyTicketMenu extends BaseMenu {
    private final Movie movie;

    public BuyTicketMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
        return null;
    }
}
