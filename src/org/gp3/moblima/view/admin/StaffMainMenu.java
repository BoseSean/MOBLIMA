package org.gp3.moblima.view.admin;

import org.gp3.moblima.model.Admin;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Main menu for staff
 */
public class StaffMainMenu extends BaseMenu {
    private Admin admin;

    public StaffMainMenu(BaseMenu previousMenu, Admin admin) {
        super(previousMenu);
        this.admin = admin;
    }

	/**
	 * Display staff main menu
	 * consists of 3 menus
	 * 1. List Movies
	 * 2. Add movies
	 * 3. Configure
	 *
	 * @return corresponding menu that the user has selected
	 */
	@Override
	public BaseMenu execute() {
		printTitle("Staff Menu");

		ArrayList<String> choices = new ArrayList<>();
		choices.add("List Movies (STAFF)");
		choices.add("Add Movie");
		choices.add("Configure");
		choices.add("Back");
		printMenuItems(choices, 0);

		int c = readChoice(0, choices.size());

		BaseMenu nextMenu = this;
		switch (c) {
			case 0:
				nextMenu = new ListMovies(this);
				break;
			case 1:
				nextMenu = new CreateMovie(this);
				break;
			case 2:
				nextMenu = new ConfigureMenu(this);
				break;
			case 3:
				nextMenu = this.getPreviousMenu();
				break;
		}
		return nextMenu;
	}

}
