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

    public class TableName {
        public final static String MOVIE = "MOVIE";
        public final static String TICKET = "TICKET";
        public final static String BOOKING = "BOOKING";
        public final static String USER = "USER";
        public final static String CINEMA = "CINEMA";
        public final static String SEAT = "SEAT";
        public final static String ADMIN = "ADMIN";
    }

}
