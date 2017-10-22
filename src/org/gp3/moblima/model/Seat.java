package org.gp3.moblima.model;

/**
 * Created by Shen Youlin on 15/10/17.
 */

public class Seat extends Model
{

    private int col,row;

    private boolean occcupied;

//    private Slot slot;

    public Seat(int col, int row, boolean occcupied) {
        this.col = col;
        this.row = row;
        this.occcupied = occcupied;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setOcccupied(boolean occcupied) {
        this.occcupied = occcupied;
    }

    public boolean isOcccupied() {
        return occcupied;
    }

//    public Slot getSlot() {
//        return slot;
//    }
//
//    public void setSlot(Slot slot) {
//        this.slot = slot;
//    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (col != seat.col) return false;
        return row == seat.row;
    }
}
