package org.gp3.moblima;

import org.gp3.moblima.model.Model;
import org.gp3.moblima.model.Movie;

import java.util.ArrayList;

public class Runner {
    public static void main (String [] args)
    {
        Movie movie = new Movie();
        movie.TID=3664645;
        Movie movie1=new Movie();
        movie1.TID=123123;
        ArrayList<Model> temp = new ArrayList<>();
        temp.add(movie);
        temp.add(movie1);

        Model.writeSerial(temp);

        temp = Model.readSerial();
        System.out.println(((Movie)temp.get(0)).TID);
        System.out.println(((Movie)temp.get(1)).TID);

    }
}
