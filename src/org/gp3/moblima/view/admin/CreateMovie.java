package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.gp3.moblima.view.IOUtil.*;

/**
 * Menu to create new movie
 */
public class CreateMovie extends BaseMenu {

    public CreateMovie(BaseMenu previousMenu) {
        super(previousMenu);
    }

    Manager manager = Manager.getInstance();
    Movie movie;
    String buf;

    /**
     * Display create new movie menu
     * Ask user to input information of the new movie
     * And, return to main staff menu
     * @return corresponding menu that the user has selected
     */
    @Override
    public BaseMenu execute() {
        movie = new Movie();
        //readln(""); //filter out the \n removed/ignored by sc.next()
        buf = readln("Input movie title: ");
        movie.setTitle(buf);
        buf = readln("Input director: ");
        movie.setDirector(buf);
        buf = readln("Input synopsis: ");
        movie.setSynopsis(buf);
        buf = readln("Input Language: ");
        movie.setLanguage(buf);
        Date Datebuf = readDate("Input opening: ");
        movie.setOpening(Datebuf);
        Date Datend = readDate("Input ending time: ");
        movie.setEnding(Datend);
        int Intbuf = readInt("Input runtime(minutes): ");
        movie.setRuntime(Intbuf);

        println("Choose Content Rating: ");
        ArrayList<String> choices = new ArrayList();
        for (Constant.ContentRating cr : Constant.ContentRating.values()) {
            choices.add(cr.toString());
        }
        printMenuItems(choices, 0);
        int c = readChoice(0, choices.size());
        movie.setContentRating(Constant.ContentRating.values()[c]);

        println("Choose Showing Status: ");
        choices.clear();
        for (Constant.ShowingStatus status : Constant.ShowingStatus.values()) {
            choices.add(status.toString());
        }
        printMenuItems(choices, 0);
        c = readChoice(0, choices.size());
        movie.setShowingStatus(Constant.ShowingStatus.values()[c]);

        buf = readln("Input casts, separated by comma: ");
        ArrayList<String> castbuf = new ArrayList<>();
        for (String singleCast : buf.split(",")) {
            castbuf.add(singleCast.trim());
        }
        movie.setCasts(castbuf);


        movie.setTicketSales(0);
        movie.setOverAllRating(0.0);
        movie.setRatingTimes(0);

        if( confirm("Confirm to add movie "+movie.getTitle()) ) {
            manager.add(Constant.Tables.MOVIE, movie);
            println("Movie \""+this.movie.getTitle()+"\" added.");
        }
        return getPreviousMenu();
    }


}
