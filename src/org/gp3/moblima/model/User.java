package org.gp3.moblima.model;

import java.util.ArrayList;

/**
 * Created by Shen Youlin on 14/10/17.
 */

public class User extends Model {
    private String name,phone,email;
    private ArrayList<Booking> bookings;


    public User(String name, String phone, String email)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;
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
}
