package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.view.BaseMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.gp3.moblima.view.IOUtil.*;

public class CreateMovie extends BaseMenu {

	public CreateMovie(BaseMenu previousMenu) {
		super(previousMenu);
	}
	Manager manager = Manager.getInstance();
    Movie movie;
    String buf;

	@Override
	public BaseMenu execute()
    {
        movie = new Movie();
        readln(""); //filter out the \n removed/ignored by sc.next()
        buf = readln("Input movie title: ");
        movie.setTitle(buf);
        buf = readln("Input director: ");
        movie.setDirector(buf);
        buf = readln("Input synopsis: ");
        movie.setSynopsis(buf);
        buf = readln("Input opening: ");
        movie.setOpening(buf);
        buf = readln("Input runtime: ");
        movie.setRuntime(buf);
        buf = readln("Input casts, separated by comma: ");

        ArrayList<String> castbuf = new ArrayList<>();
        Collections.addAll(castbuf,buf.split(","));
        movie.setCasts(castbuf);

        movie.setTicketSales(0);
        movie.setOverAllRating(0.0);

        if( confirm("Confirm to add movie "+movie.getTitle()) )
        {
            manager.add(Constant.Tables.MOVIE, movie);
            println("Movie \""+this.movie.getTitle()+"\" added.");
        }
        return getPreviousMenu();
	}


}
