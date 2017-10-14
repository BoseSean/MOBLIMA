package org.gp3.moblima.controller;

import org.gp3.moblima.model.Cinema;
import org.gp3.moblima.model.Model;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.Ticket;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.exit;

/**
 * Created by zhangxinye on 14/10/17.
 */

public class Manager {
    private static String DB_FILE_NAME = "db.ser";
    private SerializeDB db;
    private static Manager singleInstance = new Manager();

    public static Manager getInstance() {
        return singleInstance;
    }

    private Manager() {
        initDB();
    }
    public void finalize(){
        saveDB();
    }
    private void initDB()
    {
        try
        {
            File db_file = new File(DB_FILE_NAME);
            if(db_file.exists()){
                FileInputStream fileIn = new FileInputStream(db_file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                db = (SerializeDB) in.readObject();
                in.close();
                fileIn.close();
            }
            else
            {
                db = new SerializeDB();

            }
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("class not found");
            c.printStackTrace();
        }

    }
    private void saveDB()
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(DB_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this.db);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved\n");
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    private ArrayList getTable(String model) throws DBException {
        ArrayList tempArray;
        switch (model){
            case "MOVIE":   tempArray = db.movies;break;
            case "TICKET":  tempArray = db.tickets;break;
            case "BOOKING": tempArray = db.bookings;break;
            case "USER":    tempArray = db.users;break;
            case "CINEMA":    tempArray = db.cinemas;break;
            case "SEAT":    tempArray = db.seats;break;
            default: throw new DBException("Table name does not exist.");
        }
        return tempArray;
    }
    public <T extends Model> ArrayList<T> getEntries(String model, Predicate<T> filter) {

        try {
            ArrayList table = getTable(model);
            return (ArrayList<T>) table.stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
        return null;
    }

    public <T extends Model> T getEntry(String model, Predicate<T> filter) {

        try {
            ArrayList table = getTable(model);
            table.
            return (T) table.stream().filter(filter).findFirst().get();
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
        return null;
    }
    public <T extends Model> void delete(String model, Predicate<T> filter){
        try {
            ArrayList table = getTable(model);
            table.removeIf(filter);
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
    }
    public <T extends Model> void delete(String model, T entry){
        try {
            ArrayList table = getTable(model);
            table.remove(entry);
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
    }
    public <T extends Model> void add(String model, T entry){
        try {
            ArrayList table = getTable(model);
            table.add(entry);
        } catch (DBException e) {
            e.printStackTrace();
            exit(1);
        }
    }
}
