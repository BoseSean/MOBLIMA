package org.gp3.moblima.model;

import java.util.ArrayList;

/**
 * Created by Shen Youlin on 14/10/17.
 */

public class User implements Model {
    private String name, phone, email;
    private ArrayList<Booking> bookings;


    public User(String name, String phone, String password)
    {
        this.name = name;
        this.phone = phone;
        this.email = password;
        this.bookings = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBookings(Booking new_bookings){
        if(bookings == null){
            this.bookings = new ArrayList<>();
            this.bookings.add(new_bookings);
        }
        else{
            this.bookings.add(new_bookings);
        }
    }

    public void removeBookings(Booking remove_bookings){
        for(int i = 0; i < this.bookings.size(); i++){
            if(this.bookings.get(i) == remove_bookings){
                this.bookings.remove(i);
                return;
            }
        }
    }

}
