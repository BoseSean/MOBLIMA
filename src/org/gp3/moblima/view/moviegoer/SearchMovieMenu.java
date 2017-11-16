package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

/**
 *  Menu to search for a certain menu
 */
public class SearchMovieMenu extends BaseMenu {

    private Manager manager = Manager.getInstance();
    private String movieName;
    public SearchMovieMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    /**
     * Ask user to input come part of movie title
     * Display list of movies whose title contains the string provided by the user
     * Ask user which movie to check information
     *
     * @return corresponding menu that the user has selected
     */
    @Override
    public BaseMenu execute() {
        BaseMenu nextMenu = null;
        ArrayList<Movie> movies;
        movieName = null;
        printTitle("Movie Search");
        movieName = read("Input movie name to search: ");

        while (true) {
            movies = manager.getEntries(Constant.Tables.MOVIE, (Movie m) -> (m.getTitle().toLowerCase().contains(movieName.toLowerCase())));
            if (movies.isEmpty()) {
                println("Sorry, no result found. Press 0 to go back.");
                movieName = read("Input movie name to search: ");
                if(movieName.equals("0"))
                    break;
            } else {
                println("Found " + movies.size() + " results:");
                ArrayList<String> choices = new ArrayList<>();
                for (Movie m : movies) {
                    choices.add(m.getTitle());
                }
                choices.add("Back");
                printMenuItems(choices, 0);
                int c = readChoice(0, choices.size());

                if (c < movies.size())
                    nextMenu = new MovieInfo(this, movies.get(c));
                else if (c == movies.size())
                    nextMenu = getPreviousMenu();

                break;
            }
        }
        if(nextMenu!=null)
            return nextMenu;
        else
            return this.getPreviousMenu();
    }
}