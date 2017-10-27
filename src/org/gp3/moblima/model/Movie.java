package org.gp3.moblima.model;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collections;

public class Movie implements Model
{
    private String title, synopsis, opening, runtime, director;
	private int ticketSales;

	private double overAllRating;
	private int ratingTimes;
	private ArrayList<String> casts;
    private ArrayList<Slot> slots;
    private ArrayList<Review> reviews;

	public Movie(String title) {
		this.title = title;
	}

	public Movie(){

	}


	// getters
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

    public double getOverAllRating() {
        return overAllRating;
    }
    public int getRatingTimes() {
        return ratingTimes;
    }
    public double getAvgRating() { return overAllRating / (double)ratingTimes; }

    public ArrayList<String> getCasts() { return casts; };
    public ArrayList<Slot> getSlots() { return slots; }


    // setters
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
    public void setRuntime(String runtime) { this.runtime = runtime; }

	public void setOverAllRating(double overAllRating) {
		this.overAllRating = overAllRating;
	}
    public void addOverAllRating(double delta) {
        this.overAllRating += delta;
    }
	public void setRatingTimes(int ratingTimes) {
		this.ratingTimes = ratingTimes;
	}
    public void addRatingTimes(int delta) {
        this.ratingTimes += delta;
    }
    public void setTicketSales(int ticketSales) {
		this.ticketSales = ticketSales;
	}
    public void addTicketSales(int delta) {
	    this.ticketSales += delta;
	}

	// casts
    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }
    public void addCast(String some_cast) {
		if (this.casts == null) {
			ArrayList<String> c = new ArrayList<String>();
			setCasts(c);
		}
		this.casts.add(some_cast);
		// this.casts = sortCasts(this.casts);
    }


	/**
	 * Remove Cast from Movie
	 * Use equals to compare
	 * @param some_cast
	 */
	public void removeCast(String some_cast) {
        for(String c : this.casts)
            if (c.equals(some_cast)) {
                this.casts.remove(c);
                return;
            }
    }

	/**
	 * Set Review
	 * @param reviews
	 */
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	/**
	 * Add Review to Movie
	 * Review is of type String
	 * @param review
	 */
	public void addReview(Review review) {
		if (this.reviews == null) {
			ArrayList<Review> r = new ArrayList<Review>();
			this.setReviews(r);
		}
		this.reviews.add(review);
		this.addRatingTimes(1);
		// TODO overAllRating Logic not clear

	}

	/**
	 * Remove the review of a Movie
	 * Review is of type String
	 * @param review
	 */
	public void removeReview(Review review) {
		for (Review rev : this.reviews) {
			if (this.reviews.equals(review)) {
				this.reviews.remove(review);
			}
		}
	}

	public boolean actorInCasts(String some_cast) {
        for(int i = 0; i < this.casts.size(); i++)
            if (this.casts.get(i) == some_cast)
                return true;
        return false;
    }

    // slots
    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }
    public void addSlot(Slot some_slot) {
        this.slots.add(some_slot);
        // this.slots = sortSlots(this.slots);
    }
    public void removeSlot(Slot some_slot) {
        for(int i = 0; i < this.slots.size(); i++)
            if (this.slots.get(i) == some_slot) {
                this.slots.remove(i);
                return;
            }
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
                    t.ticketSales == t.ticketSales &&
                    t.overAllRating == overAllRating &&
                    t.ratingTimes == ratingTimes;
        }
        return super.equals(ob);
    }

}
