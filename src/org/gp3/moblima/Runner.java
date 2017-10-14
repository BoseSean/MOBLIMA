package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Model;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Ticket;

import java.io.*;
import java.util.ArrayList;

public class Runner {
    public static void main (String [] args) throws IOException, ClassNotFoundException {
        Movie movie = new Movie();
//        Ticket ticket = new Ticket(seat);
        ticket.setPrice(4.44444);
        movie.ticket = ticket;

        Manager man = new Manager();

        man.getEntries((Movie a)->(true));

        ArrayList<Model> movieList = new ArrayList<>();
        ArrayList<Model> ticketList = new ArrayList<>();
        movieList.add(movie);
        ticketList.add(ticket);

        ArrayList<ArrayList<Model>> tmp = new ArrayList<>();
        tmp.add(movieList);
        tmp.add(ticketList);

        FileOutputStream fileOut = new FileOutputStream("123.src");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(tmp);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved\n");

        FileInputStream fileIn = new FileInputStream("123.src");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        tmp = (ArrayList<ArrayList<Model>>) in.readObject();
        in.close();
        fileIn.close();

      //  ((Movie)tmp.get(0).get(0)).ticket.setPrice(12342432);
        System.out.println(((Ticket)tmp.get(1).get(0)).getPrice());

//        Model.writeSerial("a.src", movieList);
//        Model.writeSerial("b.src", ticketList);

//        movieList = Model.readSerial("a.src");
//        ticketList = Model.readSerial("b.src");
//        System.out.println(((Movie)movieList.get(0)).ticket.getPrice());
//        System.out.println(((Ticket)ticketList.get(0)).getPrice());

//        ticket.setPrice(5.55555);
//        System.out.println(((Movie)movieList.get(0)).ticket.getPrice());
//        System.out.println(ticket.getPrice());
    }
}
