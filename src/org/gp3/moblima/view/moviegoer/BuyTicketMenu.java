package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import static org.gp3.moblima.view.IOUtil.printTitle;

public class BuyTicketMenu extends BaseMenu {
    private final Movie movie;

    public BuyTicketMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
		printTitle("Buy Ticket Menu");
        // TODO
        // Find slot
        // Find seat
        // Select seat
        // Payment
        // Ask if student or senior
        // Confirm
        // Login
        // Create booking
        return null;
    }
}
