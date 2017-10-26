package org.gp3.moblima.model;

import java.lang.reflect.Array;
import java.util.*;

public class Slot implements Model, Comparable
{
    public Slot(int col, int row, Cinema cinema, Movie movie, Date date, Constant.MovieType movieType) {

        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=col;j++)
            {
                Seat tmpseat = new Seat(j,i,false);
                this.seats.get(i).add(tmpseat);
            }
        }

        this.cinema = cinema;
        this.movie = movie;
        this.date = date;
        this.movieType = movieType;
    }
    public Slot()
    {}


    private ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
    private Cinema cinema;
    private Movie movie;
    private Date date;
    private Constant.MovieType movieType;




    public int compareTo(Object o) {
        return 0;

    }

    public ArrayList<ArrayList<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(int row, int col) {
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=col;j++)
            {
                Seat tmpseat = new Seat(j,i,false);
                this.seats.get(i).add(tmpseat);
            }
        }
    }

    public boolean occupySeat(int row, int col)
    {
        if(this.seats.get(row).get(col).isOcccupied())
            return false;
        this.seats.get(row).get(col).setOcccupied(true);
        return true;
    }

    public boolean freeSeat(int row, int col)
    {
        if(!this.seats.get(row).get(col).isOcccupied())
            return false;
        this.seats.get(row).get(col).setOcccupied(false);
        return true;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Constant.MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(Constant.MovieType movieType) {
        this.movieType = movieType;
    }
}
