package org.gp3.moblima.view.admin;

import org.gp3.moblima.model.Admin;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class StaffMainMenu extends BaseMenu {
    private Admin admin;

    public StaffMainMenu(BaseMenu previousMenu, Admin admin) {
        super(previousMenu);
        this.admin = admin;
    }

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
