package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;

import java.io.IOException;

import static org.gp3.moblima.model.Constant.TableName.MOVIE;

public class Runner {
    public static void main (String [] args) throws IOException, ClassNotFoundException {
        Manager man = Manager.getInstance();
        Movie mov = new Movie();

        mov.setTitle("HI moon");
        man.add(MOVIE, mov);

        String s = "HI moon";
        Movie mov2 = man.getEntry(MOVIE, (Movie e) -> (e.getTitle().equals(s)));
        System.out.println(mov2.getTitle());

    }
}
