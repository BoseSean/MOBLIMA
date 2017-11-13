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
			String opening = read("New Opening Time: ");
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
        if (confirm("Update Runtime")) {
            String run = read("New Runtime: ");
			movie.setRuntime(run);
		}
		if (confirm("Update Synopsis")) {
			String synopsis = read("New Synopsis: ");
			movie.setSynopsis(synopsis);
		}
		if (confirm("Update Casts")) {
            println("Separate by comma. ");
            String cast = read("New cast: ");
            ArrayList<String> castList= new ArrayList<String>();
			Collections.addAll(castList,cast.split(","));
			movie.setCasts(castList);
		}
		if (confirm("Remove Cast")) {
			//todo 不存在的cast不能remove

			System.out.println("Separate by comma");
			String castR = read("Casts to be remove: ");
			ArrayList<String> castList= new ArrayList<String>();
			Collections.addAll(castList, castR.split(","));
			for (String c : castList) {
				movie.removeCast(c);
			}
		}
		if (confirm("Add A New Slot")) {
			Slot slot = readSlot();
			movie.addSlot(slot);
			println("Slot added.");
		}
		if (confirm("Remove Slot")) {
			ArrayList<String>choices = new ArrayList<>();
			for(Slot slot: movie.getSlots())
			{
				//todo time format
				choices.add("Cinema: " + slot.getCinema().getName()+"   Time: "+ slot.getFormattedTime() +" " + slot.getFormattedDate());
			}
			printMenuItems(choices,0);
			int c = readChoice("Please choose a slot to remove",0,choices.size());
			Slot slot = movie.getSlots().get(c);
			//Movie m = manager.getEntry(Constant.Tables.MOVIE,(Movie movie)->(movie.getTitle().equals(movie)));
			movie.removeSlot(slot);
			println("Slot removed");
		}


		return this.getPreviousMenu();
    }

	private Slot readSlot()
	{
		Cinema cinema;
		do {
			String cp = read("Input Cineplex: ");
			String s = read("Input Cinema: ");
			cinema = manager.getEntry(Constant.Tables.CINEMA, (Cinema c) -> (c.getName().equals(s) && c.getCineplex().toString().equals(cp)));
			if(cinema == null)
			{
				println("No corresponding cineplex or cinema found, please try again.");
			}
		}while(cinema==null);

		int row = readInt("Input seat rows: ",1,9);
		int col = readInt("Input seat cols: ",1,9);

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
		return new Slot(col, row,  cinema,  movie, startDate , startTime, mt , isplatinum, isSneakOrFirstWeekorblockbuster);

	}
}
