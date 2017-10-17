package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import static org.gp3.moblima.model.Constant.TableName.MOVIE;

public class Runner {
    public static void main(String[] args) {
        Manager man = Manager.getInstance();
        Movie mov = new Movie();
        mov.setTitle("HI moon");
        man.add(MOVIE, mov);
        Scanner sc = new Scanner(System.in);
        final String s = sc.nextLine();
        ArrayList<Movie> mov2 = man.getEntries(MOVIE, (Movie e) -> (e.getTitle().equals(s)));
        System.out.println(mov2.get(0).getTitle());
        final String b = sc.nextLine();
        man.delete(MOVIE, (Predicate<Movie>) (Movie e) -> (e.getTitle().equals(b)));

    }
}
