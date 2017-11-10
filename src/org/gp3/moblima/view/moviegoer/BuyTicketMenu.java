package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.controller.PriceManager;
import org.gp3.moblima.model.*;
import org.gp3.moblima.view.BaseMenu;


import javax.jws.soap.SOAPBinding;
import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.gp3.moblima.model.Constant.Tables.USER;
import static org.gp3.moblima.view.IOUtil.*;

public class BuyTicketMenu extends BaseMenu {
    private final Movie movie;
    private Manager manager = Manager.getInstance();
    public BuyTicketMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }
    @Override
    public BaseMenu execute() {


        ArrayList<String> choices = new ArrayList<>();
        int c;
        printTitle("Buy Ticket Menu");

        // Find slot
        for(Slot slot:movie.getSlots())
        {
            choices.add(slot.getCinema().getName() + " -- " + slot.getFormattedDate() + " " + slot.getFormattedTime());
        }
        printMenuItems(choices, 0);
        c = readChoice("Please Choose a slot", 0, choices.size());
        Slot slot = movie.getSlots().get(c);

        ArrayList<ArrayList<Seat>> seats = slot.getSeats();
        int col = seats.get(0).size(), row=seats.size();

        //find seat & select seat
        ArrayList<Seat>selected = new ArrayList<>();
        while(confirm("Continue to select seats?"))
        {
            displaySeats(seats,row,col);
            selected.add(chooseSeats(seats,row,col));
        }

        ArrayList<Ticket> tickets = new ArrayList<>();

        // Ask if student or senior

        if(confirm("Are you eligible for student discount?"))
        {
            for( Seat seat : selected)
            {
                Ticket ticket = new Ticket(seat,slot.getMovieType(),Constant.TicketType.STUDENT);
                tickets.add(ticket);
            }
        }
        else if(confirm("Are you eligible for senior discount?"))
        {
            for( Seat seat : selected)
            {
                Ticket ticket = new Ticket(seat,slot.getMovieType(),Constant.TicketType.SENIOR);
                tickets.add(ticket);
            }
        }
        else
        {
            Constant.TicketType ticketType = dayOfweek(slot.getDate());
            for( Seat seat : selected)
            {
                Ticket ticket = new Ticket(seat,slot.getMovieType(),ticketType);
                tickets.add(ticket);
            }
        }

        // Create booking & Payment
        boolean issnack = false;
        if(confirm("Do you want to enjoy some snack? ")) issnack = true;
        Ticket ticket = tickets.get(0);
        double totalprice = PriceManager.getPrice(ticket.getTickettype(),ticket.getMovietype(),slot.isPlatinum(),issnack) * tickets.size();
        //todo tid
        String tid = "XXXYYYYMMDDhhmm" ;
        Booking booking = new Booking(tid,slot.getDate(),totalprice,movie,slot.getCinema(),tickets);


        if (confirm("Do you have an account (Y/N) ?")) {
            login();
        } else {
            String name = read("Name: ");
            String passwd = read("Password: ");
//            manager.add(Constant.Tables.USER, new User(name, "12312312312", "));
            User user = new User(name, "1111", passwd);
            manager.add(Constant.Tables.USER, user);
        }
        // Login
//        User user = null;
//        do {
//            String name = read("Name: ");
////			name = read("Name: ");
//            user = manager.getEntry(USER, (User u) -> (u.getName().equals(name)));
//            if (user == null) {
//                println("Wrong name, please try again.");
//            }
//
//        } while (user == null);
//
//        do {
//            String email = read("Password: ");
////			email = read("Email: ");
//            user = manager.getEntry(USER, (User u) -> (u.getPassword().equals(email)));
//            if (user == null) {
//                println("Wrong email, please try again.");
//            }
//        } while (user == null);

        // Confirm
        if(confirm("Confirm to book? "))
        {
            //todo add to db
        }
        else
        {
            for(Seat seat : selected)
                seat.setSelected(false);
        }
        return this.getPreviousMenu();
    }

    private void displaySeats(ArrayList<ArrayList<Seat>> seats, int row, int col)
    {
        Seat seat;

        printTitle(" Select Seats");
        println("|      Screen       |");
        println("---------------------");

        print("   ");
        for(int i=0; i<col; i++){
            print((i+1)+"  ");
        }

        println("");

        for(int i =0; i<row; i++)
        {
            print((i+1) +" ");

            for(int j=0; j<col; j++)
            {
                seat = seats.get(i).get(j);
                if(seat.isOcccupied())
                {
                    print("[x]");
                }
                else if(seat.isSelected())
                {
                    print("[#]");
                }
                else
                    print("[ ]");

            }
            println("");
        }

        println("");
        println("     ----------");
        println("     |Entrance|\n");
        println("([#] Your seat  [ ] Avaliable  [x] Sold)");
    }

    private Seat chooseSeats(ArrayList<ArrayList<Seat>> seats, int row, int col) {
        println("Please choose your seat(s).");
        int i,j;
        do {
            i = readInt("Please input row number",1,row);
            j = readInt("Please input col number",1,col);
            i--;j--;
            if (seats.get(i).get(j).isOcccupied() || seats.get(i).get(j).isSelected())
                println("Already been taken/selected please choose another seats.");
            else break;
        } while (true);

        seats.get(i).get(j).setSelected(true);
        print("Selected Seat: Row" + i + " Col" + j);

        return new Seat(i, j, false);
    }

    public Constant.TicketType dayOfweek(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_WEEK);
        if(day <= 5 && day >= 2){
            boolean flag = false;
            ArrayList<Holiday>holidays = manager.getAll(Constant.Tables.HOLIDAY);
            for(Holiday holiday: holidays){
                if(holiday.getDate() == date){
                    flag = true;
                    break;
                }
            }
            if(flag)
                return Constant.TicketType.MON_THU;
        }
        return Constant.TicketType.FIR_SUN_AND_PH;
    }
}
