package org.gp3.moblima.controller;

import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Ticket;

import java.util.ArrayList;

/**
 * Created by zhangxinye on 14/10/17.
 */
class SerializeDB {
    ArrayList<Movie> movies;
    ArrayList<Ticket> tickets;
    public SerializeDB(){
        movies = new ArrayList<>();
        tickets = new ArrayList<>();
    }
}
