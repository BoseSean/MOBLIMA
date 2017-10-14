package org.gp3.moblima;

import org.gp3.moblima.model.Model;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Ticket;

import java.util.ArrayList;

public class Runner {
    public static void main (String [] args)
    {
        Movie movie = new Movie();
        Ticket ticket = new Ticket();
        ticket.setPrice(4.44444);
        movie.ticket = ticket;

        ArrayList<Model> movieList = new ArrayList<>();
        ArrayList<Model> ticketList = new ArrayList<>();
        movieList.add(movie);
        ticketList.add(ticket);

        Model.writeSerial("a.src", movieList);
        Model.writeSerial("b.src", ticketList);

        movieList = Model.readSerial("a.src");
        ticketList = Model.readSerial("b.src");
        System.out.println(((Movie)movieList.get(0)).ticket.getPrice());
        System.out.println(((Ticket)ticketList.get(0)).getPrice());

        ticket.setPrice(5.55555);
        System.out.println(((Movie)movieList.get(0)).ticket.getPrice());
        System.out.println(ticket.getPrice());
    }
}
