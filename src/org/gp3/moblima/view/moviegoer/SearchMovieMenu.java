package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class SearchMovieMenu extends BaseMenu {

    private Manager manager = Manager.getInstance();
    private String movieName;
    public SearchMovieMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute()
    {
        MovieInfo nextMenu = null;
        Movie movie;
        movieName = null;
        printTitle("Movie Search");
        movieName = read("Input movie name to search: ");

        movie = null;
        while (true)
        {
            movie = manager.getEntry(Constant.Tables.MOVIE, (Movie m) -> (m.getTitle().toLowerCase().contains(movieName.toLowerCase())));
            if(movie == null)
            {
                println("Sorry, no result found. Press 0 to go back.");
                movieName = read("Input movie name to search: ");
                if(movieName.equals("0"))
                    break;

            }
            else
            {
                println("Movie: "+movie.getTitle()+" found!");
                nextMenu = new MovieInfo(this,movie);
                break;
            }
        }
        if(nextMenu!=null)
            return nextMenu;
        else
            return this.getPreviousMenu();
    }
}