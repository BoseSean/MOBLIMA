package org.gp3.moblima;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.SerializeModel;

public class Runner {
    public static void main (String [] args)
    {
        Movie movie = new Movie();
        movie.TID=3664645;
        SerializeModel.writeSerial(movie);
        movie = (Movie)SerializeModel.readSerial();
        System.out.println(movie.TID);

    }
}
