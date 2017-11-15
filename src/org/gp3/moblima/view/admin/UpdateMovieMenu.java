package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Cinema;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Slot;
import org.gp3.moblima.view.BaseMenu;

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

		if (confirm("Update Title")) {
			String title = read("New Title: ");
			movie.setTitle(title);
		}
		if (confirm("Update Director")) {
			String director = read("New Director: ");
			movie.setDirector(director);
		}
		if (confirm("Update Opening Time")) {
			Date opening = readDate("input time");
			movie.setOpening(opening);
		}
        if (confirm("Update Showing Status")) {
            ArrayList<String> choices = new ArrayList();
            for (Constant.ShowingStatus status : Constant.ShowingStatus.values()) {
                choices.add(status.toString());
            }
            printMenuItems(choices, 0);
            int c = readChoice(0, choices.size());
            movie.setShowingStatus(Constant.ShowingStatus.values()[c]);
        }
		if (confirm("Update Runtime(minutes)")) {
			int run = readInt("New Runtime: ");
            movie.setRuntime(run);
		}
		if (confirm("Update Synopsis")) {
			String synopsis = read("New Synopsis: ");
			movie.setSynopsis(synopsis);
		}
        if (confirm("Update Language")) {
            String language = read("New Language: ");
            movie.setLanguage(language);
        }
        if (confirm("Update Content Rating")) {
            println("Choose Content Rating: ");
            ArrayList<String> choices = new ArrayList();
            for (Constant.ContentRating cr : Constant.ContentRating.values()) {
                choices.add(cr.toString());
            }
            printMenuItems(choices, 0);
            int c = readChoice(0, choices.size());
            movie.setContentRating(Constant.ContentRating.values()[c]);
        }
        if (confirm("Update Casts")) {
            println("Separate by comma. ");
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
			ArrayList<String> currentCast = movie.getCasts();
			for (String c : castList) {
				if (currentCast.contains(c)) {
					movie.removeCast(c);
				} else {
					println(c + " not a cast.");
				}
			}
		}
		if (confirm("Add A New Slot")) {
			Slot slot = readSlot();
			movie.addSlot(slot);
			println("Slot added.");
		}
		if (confirm("Remove Slot")) {
			ArrayList<String>choices = new ArrayList<>();
			if (movie.getSlots().size() != 0) {
				for(Slot slot: movie.getSlots())
				{
					choices.add("Cinema: " + slot.getCinema().getName()+"   Time: "+ slot.getFormattedTime() +" " + slot.getFormattedDate());
				}
				printMenuItems(choices,0);
				int c = readChoice("Please choose a slot to remove",0,choices.size());
				Slot slot = movie.getSlots().get(c);
				movie.removeSlot(slot);
				println("Slot removed");
			}
		}


		return this.getPreviousMenu();
    }

	private Slot readSlot()
	{
		ArrayList<Cinema> cinemas = manager.getAll(Constant.Tables.CINEMA);
		ArrayList<String> Cinchoices = new ArrayList<>();
		for (Cinema c : cinemas) {
            Cinchoices.add(c.getName() + " @ " + c.getCineplex());
        }

		printMenuItems(Cinchoices, 0);

		int cc = readChoice(0, Cinchoices.size());

		Cinema cinema = cinemas.get(cc);


		Date startDate = readDate("Please input Date");
		Date startTime = readTime("Please input time");
		ArrayList<String> choices = new ArrayList<>();
		println("Select movie type: ");
		for(Constant.MovieType mt : Constant.MovieType.values())
			choices.add(mt.toString());
		printMenuItems(choices,0);
		int c = readChoice("Choose movie type",0,choices.size());
		boolean isplatinum = false;


        isplatinum = confirm("Is this a platinum");

		boolean isSneakOrFirstWeekorblockbuster = false;
        isSneakOrFirstWeekorblockbuster = confirm("Is this a sneak, first week shown or blockbuster slot");

		Constant.MovieType mt = Constant.MovieType.values()[c];
		return new Slot(cinema.getCol(), cinema.getRow(),  cinema,  movie, startDate , startTime, mt , isplatinum, isSneakOrFirstWeekorblockbuster);

	}
}
