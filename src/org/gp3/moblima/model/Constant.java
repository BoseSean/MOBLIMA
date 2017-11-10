package org.gp3.moblima.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * created by hannancao on 14/10/17.
 */
public class Constant {

    public static final String FORMAT_TIME_CLOCK = "HHmm";
    public static final String FORMAT_TIME_HOUR  = "hh:mma";
    public static final String FORMAT_DATE_SHORT = "dd/MM/yyyy";
    public static final String FORMAT_DATE_LONG  = "dd MMM yyyy";
    public static final String FORMAT_BOOKING_ID = "yyyyMMddHHmm";
    public static final String FORMAT_HOLIDAY	 = "dd MMM";

    public static SimpleDateFormat dateFormatShort = new SimpleDateFormat(FORMAT_DATE_SHORT);
    public static SimpleDateFormat dateFormatLong  = new SimpleDateFormat(FORMAT_DATE_LONG);
    public static SimpleDateFormat clockFormat = new SimpleDateFormat(FORMAT_TIME_CLOCK);
    public static SimpleDateFormat timeFormat  = new SimpleDateFormat(FORMAT_TIME_HOUR);

    public static SimpleDateFormat bookingFormat = new SimpleDateFormat(FORMAT_BOOKING_ID);
    public static SimpleDateFormat holidayFormat = new SimpleDateFormat(FORMAT_HOLIDAY);
    public static SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd MMM yyyy, hh:mma");

    //Date Time format : DD/MM/YY hh:mm PM
    public static DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

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
        TWO_D_AND_JEM("Ultima 2D @ JEM & West Mall"),
        THREE_D_AND_JEM("Ultima 3D @ JEM & West Mall"),
        TWO_D_AND_WESTMALL("Elite Club 2D@ West Mall"),
        THREE_D_AND_WESTMALL("Elite Club 3D@ West Mall"),
        DOLBY_AUTO("Dolby Atmos 2D");
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
        REVIEW,
        HOLIDAY,
        TICKETPRICE
    }

}
