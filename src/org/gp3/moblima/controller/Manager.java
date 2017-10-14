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

/**
 * Created by zhangxinye on 14/10/17.
 */

public class Manager {
    private static String DB_FILE_NAME = "db.ser";
    private SerializeDB db;
    public Manager(){
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

    public <T> ArrayList<T> getEntries(Class modelType, Predicate<T> filter) {
        ArrayList tempArray = null;
        try {
            if(modelType.equals(Class.forName("org.gp3.moblima.model.Movies"))) tempArray = db.movies;
            else if (modelType.equals(Class.forName("org.gp3.moblima.model.Ticket"))) tempArray = db.tickets;
            return (ArrayList<T>) tempArray.stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
public static void main(String[] args){

}
}
