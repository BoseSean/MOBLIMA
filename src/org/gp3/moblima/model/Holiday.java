package org.gp3.moblima.model;


import java.util.Date;
/**
 * The Model to hold all the Holiday discount info.
 * Is Comparable for comparison of weekdays
 *
 */
public class Holiday implements Model {

	private Date date;
    private String name;

    public Holiday(){}

    public Date getDate() {
        return date;
    }


    public String getName() {

        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormatedDate() {
        return Constant.dateFormatLong.format(date);
    }

    @Override
    public String toString() {
        return getName() + " " + getFormatedDate();
    }

    @Override
    public boolean equals(Object ob){
        if(ob instanceof Holiday){
            Holiday holiday = (Holiday) ob;
            return holiday.name.equals(this.name) && holiday.date.equals(this.date);
        }
        return super.equals(ob);
    }

}
