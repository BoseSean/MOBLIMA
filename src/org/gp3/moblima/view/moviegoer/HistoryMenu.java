package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.model.Booking;
import org.gp3.moblima.model.Ticket;
import org.gp3.moblima.model.User;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to check history
 */
public class HistoryMenu extends BaseMenu {


    public HistoryMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

	/**
	 * Display user booking history menu
	 * Ask user for login information
	 * Display all user booking detail
	 * Return to previous menu when done
	 * @return to previous menu
	 */
	@Override
    public BaseMenu execute() {
        printTitle("History");
		printTitle("Please Login Using Username and Email");

		User user;

		user = login();

		if (user != null) {
			ArrayList<Booking> booking = user.getBookings();
            println("In total "+booking.size() +" bookings found under "+user.getName()+".");
			int cnt=1;
			for (Booking book : booking) {
				println();
				println();
				println("Booking "+cnt + " :");
                cnt++;
				println("TID: " + book.getTID());
				println("Booking Time: " + book.getTimestamp());
				println("Show TIme: " + book.getDate() + " " + book.getTime());
				println("Total Price (GST included): S$" + book.getTotalPrice());
				println("Cineplex: " + book.getCinema().getCineplex().toString());
				println("Cinema: " + book.getCinema().getName());
				println("Movie: " + book.getMovie().getTitle());
				println("Seats :");
				for(Ticket ticket: book.getTickets()){
					println("Row: "+(ticket.getSeat().getRow()+1)+" Col: "+ (ticket.getSeat().getCol()+1));
				}
			}
		}
        while(readInt("Press 0 to return to previous menu: ") != 0);
		return this.getPreviousMenu();
	}

}
