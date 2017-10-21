package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.model.User;
import org.gp3.moblima.model.Booking;
import static org.gp3.moblima.model.Constant.TableName.USER;

import java.awt.print.Book;
import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class HistoryMenu extends BaseMenu {


    public HistoryMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("History");

		printTitle("Please Login Using Username and Password");


		Manager man = Manager.getInstance();

		User user = null;


//		User user = man.getEntry(USER,
//				(User u) -> (
//						u.getName().equals(name) &&
//								u.getEmail().equals(email))
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

		do {
			String name = read("Name: ");
//			name = read("Name: ");
			user = man.getEntry(USER, (User u) -> (u.getName().equals(name)));
			if (user == null) {
				println("Wrong Name");
			}

		} while (user == null);

		do {
			String email = read("Email: ");
//			email = read("Email: ");
			user = man.getEntry(USER, (User u) -> (u.getEmail().equals(email)));
			if (user == null) {
				println("Wrong Email");
			}
		} while (user == null);


			ArrayList<Booking> booking = user.getBookings();

			for (Booking book : booking) {
				book.getInfo();
			}

		return this.getPreviousMenu();
	}
}
