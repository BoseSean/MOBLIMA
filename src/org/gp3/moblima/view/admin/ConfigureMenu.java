package org.gp3.moblima.view.admin;

import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * The main configuration menu
 */
public class ConfigureMenu extends BaseMenu {
	public ConfigureMenu(BaseMenu previousMenu) {
		super(previousMenu);
	}

	/**
	 * Display configure the main configuration menu
	 * Consist of 2 menus:
	 * 1. Configure Prices
	 * 2. Configure Holidays
	 */
	@Override
	public BaseMenu execute() {

		printTitle("Configure System Menu");

		ArrayList<String> choices = new ArrayList<String>();

		choices.add("Configure Price");
		choices.add("Configure Holidays");
		choices.add("Back");

		printMenuItems(choices, 0);

		int c = readChoice(0, choices.size());

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
