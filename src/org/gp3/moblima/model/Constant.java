package org.gp3.moblima.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * created by hannancao on 14/10/17.
 */
public class Constant {

    public static enum TicketType {
        SENIOR("Senior Citizens"),
        STUDENT("Student"),
        MON_THU("Mon - Thu"),
        FIR_SUN_AND_PH("Fri - Sun & PH"),


        private String date;

        private TicketType(String data){
            this.date = data;
        }
        @Override
        public String toString(){
            return this.date;
        }
    }

}
