package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Seat;
import org.gp3.moblima.model.Slot;
import org.gp3.moblima.view.BaseMenu;

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
            choices.add(slot.getCinema().getName() + " " + slot.getDate() + " " + " ");
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
        if(confirm("Are you eligible for student discount?"))
        {

        }
        else if(confirm("Are you eligible for senior discount?"))
        {

        }

        // Confirm
        // Login
        // Create booking
        //todo if(booking not successful, release selected seats)
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
        int i,j;
        do {
            i = readInt("Please input row number",1,row);
            j = readInt("Please input col number",1,col);

            if (seats.get(--i).get(--j).isOcccupied() || seats.get(--i).get(--j).isSelected())
                println("Already been taken/selected please choose another seats.");
            else break;
        } while (true);

        seats.get(i).get(j).setSelected(true);
        print("Selected Seat: Row" + i + " Col" + j);

        return new Seat(i, j, false);
    }
}
