package org.gp3.moblima.model;

import java.util.ArrayList;

public class Movie extends Model
{
    private String title,synopsis,opening,runtime,director;
    private ArrayList<String> casts;

    public Ticket ticket;



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

}
