package org.gp3.moblima.model;

import java.util.ArrayList;

public class Movie extends Model
{
    private String title,synopsis,opening,runtime,director;
    private ArrayList<String> casts;

    // What is this for?
    private Ticket ticket;

	private int ticketSales;

	private double overAllRating;

	private int ratingTimes;

	public double getOverAllRating() {
		return overAllRating;
	}

	public int getRatingTimes() {
		return ratingTimes;
	}


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

	public void setOverAllRating(double overAllRating) {
		this.overAllRating = overAllRating;
	}


	public void setRatingTimes(int ratingTimes) {
		this.ratingTimes = ratingTimes;
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

    @Override
    public boolean equals(Object ob){
        if(ob instanceof Movie){
            Movie t = (Movie) ob;
            return t.title == title && t.casts == casts &&
                    t.synopsis == synopsis && t.opening == opening &&
                    t.runtime == runtime && t.director == director &&
                    t.ticket == ticket && t.ticketSales == t.ticketSales &&
                    t.overAllRating == overAllRating &&
                    t.ratingTimes == ratingTimes;
        }
        return super.equals(ob);
    }

}
