package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Booking;
import org.gp3.moblima.model.Ticket;
import org.gp3.moblima.model.User;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.model.Constant.Tables.USER;
import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by zhangxinye on 19/10/17.
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
	 * @return
	 */
	@Override
    public BaseMenu execute() {
        printTitle("History");
		printTitle("Please Login Using Username and Email");


		Manager man = Manager.getInstance();

		User user;

//		User user = man.getEntry(USER,
//				(User u) -> (
//						u.getName().equals(name) &&
//								u.getPassword().equals(email))
//		);
//
//		if (user == null) {
//			return this;
//		} else {
//			ArrayList<Booking> booking = user.getBookings();
//
//			for (Booking book : booking) {
//				book.getInfo();
//			}
//
//			return this.getPreviousMenu();
//
//		}

//		do {
//			String name = read("Name: ");
////			name = read("Name: ");
//			user = man.getEntry(USER, (User u) -> (u.getName().equals(name)));
//			if (user == null) {
//				println("Wrong name, please try again.");
//			}
//
//		} while (user == null);
//
//		do {
//			String email = read("Password: ");
////			email = read("Email: ");
//			user = man.getEntry(USER, (User u) -> (u.getPassword().equals(email)));
//			if (user == null) {
//				println("Wrong email, please try again.");
//			}
//		} while (user == null);

		user = login();

		if (user != null) {
			ArrayList<Booking> booking = user.getBookings();
            println("In total "+booking.size() +" bookings found under "+user.getName()+".");
			int cnt=1;
			for (Booking book : booking) {
				println("Booking "+cnt + " :");
                cnt++;
				println("TID: " + book.getTID());
				println("Date: " + book.getDate());
				println("Total Price (GST included): S$" + book.getTotalPrice());
				println("Cineplex: " + book.getCinema().getCineplex().toString());
				println("Cinema: " + book.getCinema().getName());
				println("Movie: " + book.getMovie().getTitle());
				print("Seats :");
				for(Ticket ticket: book.getTickets()){
					println("       Row: "+(ticket.getSeat().getRow()+1)+" Col: "+ (ticket.getSeat().getCol()+1));
				}
			}
		}
        while(readInt("Press 0 to return to previous menu: ") != 0);
		return this.getPreviousMenu();
	}

}
