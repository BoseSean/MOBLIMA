package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Cinema;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Slot;
import org.gp3.moblima.view.BaseMenu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.gp3.moblima.view.IOUtil.*;

public class UpdateMovieMenu extends BaseMenu {

    private Movie movie;
    private Manager manager;
    public UpdateMovieMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
        this.manager = Manager.getInstance();
    }

    @Override
    public BaseMenu execute() {
    	printTitle("Update Movie Info Menu");

//		ArrayList<String> choices = new ArrayList<>();

//		choices.add("Update Title");
//		choices.add("Update Director");
//		choices.add("Update Opening Time");
//		choices.add("Update Runtime");
//		choices.add("Update Synopsis");
//		choices.add("Add Casts");
//		choices.add("Remove Casts");
//		choices.add("Update Slot");
//		choices.add("Remove Slot");
//		choices.add("Back");

//		printMenuItems(choices, 0);

//		int c = readChoice("Choice (0-" + choices.size() + ") : ", choices.size());

//		BaseMenu nextMenu = this;


		if (confirm("Update Title")) {
			String title = read("New Title: ");
			movie.setTitle(title);
		}
		if (confirm("Update Director")) {
			String director = read("New Director: ");
			movie.setDirector(director);
		}
		if (confirm("Update Opening Time")) {
			String opening = read("New Opening Time: ");
			movie.setOpening(opening);
		}
		if (confirm("Update Runtime")) {
			String run = read("New Runtime: ");
			movie.setRuntime(run);
		}
		if (confirm("Update Synopsis")) {
			String synopsis = read("New Synopsis: ");
			movie.setSynopsis(synopsis);
		}
		if (confirm("Update Casts")) {
			System.out.println("Separate by comma. ");
			String cast = read("New cast: ");
			ArrayList<String> castList= new ArrayList<String>();
			Collections.addAll(castList,cast.split(","));
			movie.setCasts(castList);
		}
		if (confirm("Remove Cast")) {
			System.out.println("Separate by comma");
			String castR = read("Casts to be remove: ");
			ArrayList<String> castList= new ArrayList<String>();
			Collections.addAll(castList, castR.split(","));
			for (String c : castList) {
				movie.removeCast(c);
			}
//			movie.removeCast(castR);
		}
		if (confirm("Update Slot")) {
			Slot slot = readSlot();
			movie.addSlot(slot);
			println("Slot added.");
		}
		if (confirm("Remove Slot")) {
			//todo 输入slot还是选择slot？
			Slot slot = readSlot();
			while(true)
			{
				for(Slot s : movie.getSlots())
				{
					if(s.equals(slot))
					{
						movie.removeSlot(s);
						println("Slot removed");
						break;
					}
				}
				println("No same slot found, please check your input");
			}

		}


		return this.getPreviousMenu();
    }
    private Slot readSlot()
	{
		Cinema cinema = manager.getEntry(Constant.Tables.CINEMA,(Cinema c)->(c.getName().equals(read("Input Cinema"))));
		int row = readInt("Input seat rows"), col = readInt("Input seat cols");
		String date = read("Input New Date (DD/MM): ");
		date = date + "/2017";
		DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		Date startDate = new Date();
		try {
			startDate = df.parse(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<String> choices = new ArrayList<>();
		for(Constant.MovieType mt : Constant.MovieType.values())
			choices.add(mt.toString());
		printMenuItems(choices,0);
		int c = readChoice("Choose movie type",0,choices.size());
		Constant.MovieType mt = Constant.MovieType.values()[c];
		return new Slot(col, row,  cinema,  movie, startDate , mt);

	}
}
