package org.gp3.moblima.model;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;


public class Slot implements Model, Comparable
{
    private ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
    private Cinema cinema;
    private Movie movie;
    private Date date,time;
    private Constant.MovieType movieType;
    private boolean platinum;
    private boolean SneakOrFirstWeekorblockbuster;

    public Slot(int col, int row, Cinema cinema, Movie movie, Date date, Date time, Constant.MovieType movieType, boolean plat, boolean SneakOrFirstWeekorblockbuster) {

        for(int i=0;i<row;i++)
        {
            this.seats.add(new ArrayList<Seat>());
            for(int j=0;j<col;j++)
            {
                Seat tmpseat = new Seat(j,i,false);
                this.seats.get(i).add(tmpseat);
            }
        }
        this.SneakOrFirstWeekorblockbuster = SneakOrFirstWeekorblockbuster;
        this.platinum = plat;
        this.cinema = cinema;
        this.movie = movie;
        this.date = date;
        this.movieType = movieType;
        this.time = time;
    }

    public Slot()
    {}


    public int compareTo(Object o)
    {
        Slot s = (Slot) o;
        return this.date.compareTo(s.date);
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


    public String getFormattedDate() {
        return Constant.holidayFormat.format(date);
    }

    public String getFormattedTime() { return  Constant.clockFormat.format(time);}

    public void setDate(Date date) {
        this.date = date;
    }

    public Constant.MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(Constant.MovieType movieType) {
        this.movieType = movieType;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isSneakOrFirstWeekorblockbuster() {
        return SneakOrFirstWeekorblockbuster;
    }

    public void setSneakOrFirstWeekorblockbuster(boolean sneakOrFirstWeekorblockbuster) {
        SneakOrFirstWeekorblockbuster = sneakOrFirstWeekorblockbuster;
    }
}
