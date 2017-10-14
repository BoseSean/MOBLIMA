package org.gp3.moblima.model;


import java.util.Date;
/**
 * created by hannancao on 14/10/17.
 */
public class Holiday extends Model {

    private int id;
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
//    public Holiday clone (){
//        Holiday holiday  = new Holiday();
//        holiday.id = this.id;
//        holiday.date = this.date;
//        holiday.name = this.name;
//        return holiday;
//    }
//
////    @Override
////    public boolean equals(Object ob){
////        if(ob instanceof Holiday){
////            Holiday holiday = (Holiday) ob;
////            return holiday.id == this.id;
////        }
////        return super.equals(ob);
////    }
////
////    @Override
////    public String toDisplay(){
//
//    }
}
