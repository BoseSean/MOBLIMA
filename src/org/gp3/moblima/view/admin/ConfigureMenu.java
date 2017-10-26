package org.gp3.moblima.view.admin;

import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

public class ConfigureMenu extends BaseMenu {
    public ConfigureMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {

        printTitle("Configure System Menu");

		ArrayList<String> choices = new ArrayList<String>();

		choices.add("Configure Price");
		choices.add("Configure Holidays");
		choices.add("Back");

		printMenuItems(choices, 0);

		int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

		BaseMenu nextMenu = this;

		switch (c) {
			case 0:
				nextMenu = new ConfigurePriceMenu(this);
				break;
			case 1:
				nextMenu = new ConfigureHolidayMenu(this);
				break;
			case 2:
				nextMenu = this.getPreviousMenu();
				break;

		}

		return nextMenu;
	}
}
