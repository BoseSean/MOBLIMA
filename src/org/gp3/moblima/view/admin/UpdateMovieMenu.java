package org.gp3.moblima.view.admin;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;
import java.util.Collections;

import static org.gp3.moblima.view.IOUtil.*;

public class UpdateMovieMenu extends BaseMenu {

    private Movie movie;
    public UpdateMovieMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
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
			// TODO slot logic
		}
		if (confirm("Remove Slot")) {
			// TODO slot logic
		}

//		switch (c) {
//			case 1:
//				String title = read("New Title: ");
//				movie.setTitle(title);
//				break;
//
//			case 2:
//				String director = read("New Director: ");
//				movie.setDirector(director);
//				break;
//			case 3:
//				String opening = read("New Opening Time: ");
//				movie.setOpening(opening);
//				break;
//			case 4:
//				String runtime = read("New Runtime: ");
//				movie.setRuntime(runtime);
//				break;
//			case 5:
//				String synopsis = read("New Synopsis");
//				movie.setSynopsis(synopsis);
//				break;
//			case 6:
//				String cast = read("New Cast: ");
//				movie.addCast(cast);
//				break;
//			case 7:
//				String castR = read("Casts to be remove: ");
//				movie.removeCast(castR);
//				break;
//			case 8:
//				// TODO Update Slot logic
//				break;
//			case 9:
//				// TODO Remove Slot Logic
//				break;
//			default:
//				break;
//		}

		return this.getPreviousMenu();
    }
}
