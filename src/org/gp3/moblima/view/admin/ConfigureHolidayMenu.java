package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Holiday;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;
import java.util.Date;

import static org.gp3.moblima.model.Constant.Tables.HOLIDAY;
import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to configure holiday
 */
public class ConfigureHolidayMenu extends BaseMenu {
	public ConfigureHolidayMenu(BaseMenu previousMenu) {
		super(previousMenu);
	}

	/**
	 * Display configure holiday menu
	 * Ask user to add or remove
	 * and bring user back to configure menu.
	 *
	 * @return configure menu
	 */

	@Override
	public BaseMenu execute() {
		printTitle("Configure Holiday Menu");

		Manager manager = Manager.getInstance();

		ArrayList<String> choices = new ArrayList<String>();

		Holiday holiday = new Holiday();

		choices.add("Update Holiday");
		choices.add("Remove Holiday");
		choices.add("Add New Holiday");
		choices.add("Back");

		printMenuItems(choices, 0);

		int c = readChoice(0, choices.size());
		ArrayList<Holiday> holidays = manager.getAll(Constant.Tables.HOLIDAY);
		ArrayList<String> Hochoices = new ArrayList<>();
		for (Holiday h : holidays) {
			Hochoices.add(h.toString());
		}
		int hc = 0;
		int k;
		Date startdate = null;
		switch (c) {
			case 0:
				k = 0;
				while (Hochoices.size() == 0 && k != 0) {
					k = readInt("No avaliable holiday to update, please press 1 to go back: ");
					if(k == 1){
						BaseMenu nextMenu = this;
						nextMenu = new ConfigureHolidayMenu(this);
						return nextMenu;
					}
				}
				printMenuItems(Hochoices, 0);
				println("Select Holiday to be updated: ");

				hc = readChoice(0, Hochoices.size());

				holiday = holidays.get(hc);

				String newName = read("Input New Holiday Name: ");
				holiday.setName(newName);
				startdate = readDate("Please new Date: ");
				holiday.setDate(startdate);
				break;
			case 1:
				k = 0;
				while (Hochoices.size() == 0 && k != 0) {
					k = readInt("No avaliable holiday to update, please press 1 to go back: ");
					if(k == 1){
						BaseMenu nextMenu = this;
						nextMenu = new ConfigureHolidayMenu(this);
						return nextMenu;
					}
				}
				println("Select Holiday to be removed: ");

				printMenuItems(Hochoices, 0);

				hc = readChoice(0, Hochoices.size());

				holiday = holidays.get(hc);
				manager.delete(HOLIDAY, holiday);
				break;
			case 2:
				String name = read("Input New Holiday Name: ");
				holiday.setName(name);
				startdate = readDate("Please input Date: ");
				holiday.setDate(startdate);
				manager.add(HOLIDAY, holiday);
				break;
		}

		return this.getPreviousMenu();
	}

}
