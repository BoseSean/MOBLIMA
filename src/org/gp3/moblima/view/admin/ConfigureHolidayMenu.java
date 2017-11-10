package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
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

		printMenuItems(choices, 0);

		int c = readChoice(0, choices.size());

		switch (c) {
			case 0:
				String name = read("Input Holiday Name");
				holiday = manager.getEntry(HOLIDAY, (Holiday h) -> (h.getName().equals(name)));
				if (holiday != null) {
					String newName = read("Input New Holiday Name: ");
					holiday.setName(newName);
					Date startdate = readDate("Please new Date: ");
					holiday.setDate(startdate);
//					String date = read("Input New Date (DD/MM): ");
//					date = date + "/2017";
//					DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
//					Date startDate;
//					try {
//						startDate = df.parse(date);
//						holiday.setDate(startDate);
//					} catch (ParseException e) {
//						e.printStackTrace();
//					} finally {
//						println("Update Done");
//					}

				} else {
					println("Holiday Does Not Exists");
				}
				break;
			case 1:
				name = read("Input Holiday to be remove: ");
				holiday = manager.getEntry(HOLIDAY, (Holiday h) -> (h.getName().equals(name)));
				if (holiday != null) {
					manager.delete(HOLIDAY, holiday);
				} else {
					println("Holiday Does Not Exists");
				}
				break;
			case 2:
				name = read("Input New Holiday Name: ");
				holiday.setName(name);
				Date startdate = readDate("Please input Date: ");
				holiday.setDate(startdate);
				manager.add(HOLIDAY, holiday);
//				String date = read("Input New Date (DD/MM): ");
//				date = date + "/2017";
//				DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
//				Date startDate;
//				try {
//					startDate = df.parse(date);
//					holiday.setDate(startDate);
//					manager.add(HOLIDAY, holiday);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				finally {
//					println("New Holiday Added");
//				}
				break;
		}

		return this.getPreviousMenu();
	}

}
