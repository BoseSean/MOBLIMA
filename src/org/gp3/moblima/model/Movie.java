package org.gp3.moblima.model;

import java.util.ArrayList;

public class Movie extends Model
{
    private String title,synopsis,opening,runtime,director;
    private ArrayList<String> casts;

    // What is this for?
    public Ticket ticket;

	public int ticketSales;

	public double overAllRating;



    public String getDirector() {
        return director;
    }

    public String getOpening() {
        return opening;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getTitle() {
        return title;
    }

	public int getTicketSales() {
		return ticketSales;
	}


    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setTicketSales(int ticketSales) {
		this.ticketSales = ticketSales;
	}


    public void addTicket(int ticketSales) {
		this.ticketSales += 1;
	}

//	public static ArrayList<Movie> sortTicketSales(ArrayList<Movie> movies) {
//		Collections.sort(movies, new Comparator<Movie>() {
//			@Override
//			public int compare(Movie m1, Movie m2) {
//				return (m1.getTicketSales() - m2.getTicketSales());
//			}
//
//		});
//
//		return movies;
//	}


}
