package org.gp3.moblima.model;

/**
 * created by hannancao on 14/10/17.
 */
public class Constant {
    public enum TicketType {
        SENIOR("Senior Citizens"),
        STUDENT("Student"),
        MON_THU("Mon - Thu"),
        FIR_SUN_AND_PH("Fri - Sun & PH"),
        MON_FRI_6("Mon to Fri, for movies before 6pm");

        private String date;

        TicketType(String data) {
            this.date = data;
        }
        @Override
        public String toString(){
            return this.date;
        }
    }

    public enum MovieType {
        TWO_D("2D Movies"),
        THREE_D("3D Movies"),
        JEM("JEM & West Mall"),
        WESTMALL("West Mall");

        private String date;

        MovieType(String data) {
            this.date = data;
        }
        @Override
        public String toString(){
            return this.date;
        }
    }

    /**
     *
     */
    public enum Tables {
        MOVIE,
        TICKET,
        BOOKING,
        USER,
        CINEMA,
        SEAT,
        ADMIN,
    }

}
