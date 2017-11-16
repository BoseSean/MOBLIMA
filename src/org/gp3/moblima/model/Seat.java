package org.gp3.moblima.model;

/**
 * The model to hold a seat location and its status whether occupied or has been selected or not
 */
public class Seat implements Model
{

    private int col,row;

    private boolean occcupied,selected;

    public Seat(int col, int row, boolean occcupied) {
        this.col = col;
        this.row = row;
        this.occcupied = occcupied;
        this.selected = false;
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


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (col != seat.col) return false;
        return row == seat.row;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
