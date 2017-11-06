package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Seat;
import org.gp3.moblima.model.Slot;
import org.gp3.moblima.view.BaseMenu;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.*;

public class BuyTicketMenu extends BaseMenu {
    private final Movie movie;

    public BuyTicketMenu(BaseMenu previousMenu, Movie movie) {
        super(previousMenu);
        this.movie = movie;
    }

    @Override
    public BaseMenu execute() {
        Manager manager = Manager.getInstance();


        ArrayList<String> choices = new ArrayList<>();
        int c, rowCnt=0, colCnt=0;
        printTitle("Buy Ticket Menu");

        // Find slot
        for(Slot slot:movie.getSlots())
        {
            choices.add(slot.getCinema() + " " + slot.getDate() + " " + " ");
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

        // Payment
        // Ask if student or senior
        // Confirm
        // Login
        // Create booking
        return null;
    }

    private void displaySeats(ArrayList<ArrayList<Seat>> seats, int row, int col)
    {
        Seat seat;

        printTitle(" Select Seats");
        println("           |      Screen       |");
        println("           ---------------------");


        for(int i=0; i<col; i++){
            print(" " + (i+1) +" ");
        }

        println("");

        for(int i =0; i<row; i++)
        {
            print("   "+(i+1) +" ");

            for(int j=0; j<col; j++)
            {
                seat = seats.get(row).get(col);
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
        println("                ----------");
        println("                |Entrance|\n");
        println("([#] Your seat  [ ] Avaliable  [x] Sold)");
    }

    private Seat chooseSeats(ArrayList<ArrayList<Seat>> seats, int row, int col) {
        println("Please choose your seat(s).");

        do {
            row = readInt("Please input row number");
            col = readInt("Please input col number");

            if (seats.get(--row).get(--col).isOcccupied() || seats.get(--row).get(--col).isSelected())
                println("Already been taken/selected please choose another seats.");
            else break;
        } while (true);

        seats.get(row).get(col).setSelected(true);
        print("Selected Seat: Row" + row + " Col" + col);

        return new Seat(row, col, false);
    }
}
