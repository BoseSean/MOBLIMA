package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Holiday;
import org.gp3.moblima.view.BaseMenu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.gp3.moblima.model.Constant.Tables.HOLIDAY;
import static org.gp3.moblima.view.IOUtil.*;

public class ConfigureHolidayMenu extends BaseMenu {
    public ConfigureHolidayMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

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
			Hochoices.add(h.getName());
		}
		int hc = 0;

		Date startdate = null;
		switch (c) {
			case 0:
//				String name = read("Input Holiday Name: ");
				printMenuItems(Hochoices, 0);

				println("Select Holiday to be updated: ");

				hc = readChoice(0, Hochoices.size());

				holiday = holidays.get(hc);



//				holiday = manager.getEntry(HOLIDAY, (Holiday h) -> (h.getName().equals(name)));
//				if (holiday != null) {
				String newName = read("Input New Holiday Name: ");
				holiday.setName(newName);
				startdate = readDate("Please new Date: ");
				holiday.setDate(startdate);

//				} else {
//					println("Holiday Does Not Exists");
//				}
				break;
			case 1:
//				name = read("Input Holiday to be remove: ");
//				holiday = manager.getEntry(HOLIDAY, (Holiday h) -> (h.getName().equals(name)));
//				if (holiday != null) {
				println("Select Holiday to be removed: ");
				printMenuItems(Hochoices, 0);

				hc = readChoice(0, Hochoices.size());

				holiday = holidays.get(hc);
				manager.delete(HOLIDAY, holiday);
//				} else {
//					println("Holiday Does Not Exists");
//				}
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
