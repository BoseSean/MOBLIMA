package org.gp3.moblima.model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by Shen Youlin on 15/10/17.
 */

public class Cinema extends Model
{
    private String name;
    private boolean isPlatinum;
    private ArrayList<Slot> slots;

    public Cinema(String name, boolean isPlatinum, ArrayList<Slot> slots) {
        this.name = name;
        this.isPlatinum = isPlatinum;
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlatinum() {
        return isPlatinum;
    }

    public void setPlatinum(boolean platinum) {
        isPlatinum = platinum;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
            this.slots = slots;
    }

    public void addSlot(Slot some_slot) {
        this.slots.add(some_slot);
        this.slots = sortSlots(this.slots);
    }

    public void removeSlot(Slot some_slot) {
        for(int i = 0; i < this.slots.size(); i++)
            if (this.slots.get(i) == some_slot) {
                this.slots.remove(i);
                return;
            }
    }

    private static ArrayList<Slot> sortSlots(ArrayList<Slot> slots) {
		Collections.sort(slots);
		return slots;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cinema) {
            Cinema t = (Cinema) obj;
            return (t.name == name && t.isPlatinum == isPlatinum);
        }
        return super.equals(obj);
    }
}
