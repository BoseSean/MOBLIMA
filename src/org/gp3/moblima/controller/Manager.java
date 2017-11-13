package org.gp3.moblima.controller;

import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.exit;

/**
 * Created by zhangxinye on 14/10/17.
 */

public class Manager {
    private static final String DB_FILE_NAME = "db.ser";
    private static Manager singleInstance = new Manager();
    private SerializeDB db;

    private Manager() {
        init();
//        ArrayList<TicketPrice> temp = new ArrayList();
//        temp.add(new TicketPrice());
//        db.ticketprice = temp;
    }

    public static Manager getInstance() {
        return singleInstance;
    }

    public void finalize() {
        commit();
    }

    /**
     * Save the changed db into the file.
     * This method should be called everytime after the modification to the database.
     */
    public void commit() {
        try {
            FileOutputStream fileOut = new FileOutputStream(DB_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this.db);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Get all entries from the model table.
     * @param from  Name String of table
     * @param <T>   Subclass of Model, and should be corresponding to from
     * @return List of all entries in the specified table;
     */
    public <T extends Model> ArrayList<T> getAll(Constant.Tables from) {
        try {
            return (ArrayList<T>) getTable(from).clone();
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
        return null;
    }

    /**
     * Get a List of entries in model table that satisfy where.
     * @param from  Name String of table
     * @param where Predicate filter. eg. of (User a)->(a.getName()=="Genius Bug")
     * @param <T>   Subclass of Model, and should be corresponding to from
     * @return List of Models in model table that satisfy filter
     */
    public <T extends Model> ArrayList<T> getEntries(Constant.Tables from, Predicate<T> where) {

        try {
            ArrayList table = getTable(from);
            return (ArrayList<T>) table.stream().filter(where).collect(Collectors.toCollection(ArrayList::new));
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
        return null;
    }

    /**
     * Get the first entry from the model table that satisfy where.
     *
     * @param from  Name String of table
     * @param where Predicate filter. eg. of (User a)->(a.getName()=="Genius Bug")
     * @param <T>   Subclass of Model, and should be corresponding to from
     * @return A instance the satisfy filter
     */
    public <T extends Model> T getEntry(Constant.Tables from, Predicate<T> where) {

        try {
            ArrayList table = getTable(from);
            return (T) table.stream().filter(where).findFirst().get();
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        } catch (java.util.NoSuchElementException e) {
            return null;
        }
        return null;
    }

    /**
     * Remove all enrties that satisfy where from the model table.
     * @param from  Name String of table
     * @param where Predicate filter. eg. of (User a)->(a.getName()=="Genius Bug")
     * @param <T>   Subclass of Model, and should be corresponding to from
     */
    public <T extends Model> void delete(Constant.Tables from, Predicate<T> where) {
        try {
            ArrayList table = getTable(from);
            table.removeIf(where);
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
    }


    /**
     * Remove the give entry from the model table.
     * @param from  Name String of table
     * @param entry Entry to be deleted
     * @param <T>   Subclass of Model, and should be corresponding to from
     */
    public <T extends Model> void delete(Constant.Tables from, T entry) {
        try {
            ArrayList table = getTable(from);
            table.remove(entry);
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
    }

    /**
     * Add the new entry into the model table.
     * @param into  Name String of table
     * @param entry Entry to be added
     * @param <T>   Subclass of Model, and should be corresponding to from
     */
    public <T extends Model> void add(Constant.Tables into, T entry) {
        try {
            ArrayList table = getTable(into);
            table.add(entry);
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
    }

    private void init() {
        try {
            File db_file = new File(DB_FILE_NAME);
            if (db_file.exists()) {
                FileInputStream fileIn = new FileInputStream(db_file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                db = (SerializeDB) in.readObject();
                in.close();
                fileIn.close();
            } else {
                db = new SerializeDB();

            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found!");
            c.printStackTrace();
        }

    }

    private ArrayList getTable(Constant.Tables table) throws DBException {
        ArrayList tempArray;
        switch (table) {
            case ADMIN:
                tempArray = db.admins;
                break;
            case MOVIE:
                tempArray = db.movies;
                break;
            case TICKET:
                tempArray = db.tickets;
                break;
            case BOOKING:
                tempArray = db.bookings;
                break;
            case USER:
                tempArray = db.users;
                break;
            case CINEMA:
                tempArray = db.cinemas;
                break;
            case SEAT:
                tempArray = db.seats;
                break;
            case REVIEW:
                tempArray = db.seats;
                break;
            case HOLIDAY:
                tempArray = db.holidays;
                break;
            case TICKETPRICE:  //new added
                tempArray = db.ticketprice;
                break;
            default:
                tempArray = null;
        }
        return tempArray;
    }
}
