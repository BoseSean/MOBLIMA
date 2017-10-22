package org.gp3.moblima.model;



import java.io.*;
import java.util.ArrayList;

/**
 * Created by Shen Youlin on 14/10/17.
 */


public class Model implements java.io.Serializable
{
//    public static void writeSerial(String filename, ArrayList<Model> models)
//    {
//        try
//        {
//            FileOutputStream fileOut = new FileOutputStream(filename);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//
//            out.writeObject(models);
//            out.close();
//            fileOut.close();
//            System.out.printf("Serialized data is saved\n");
//        }
//        catch(IOException i)
//        {
//            i.printStackTrace();
//        }
//    }
//    @Nullable
//    public static ArrayList<Model> readSerial(String filename)
//    {
//        ArrayList<Model> models = null;
//        try
//        {
//            FileInputStream fileIn = new FileInputStream(filename);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            models = (ArrayList<Model>) in.readObject();
//            in.close();
//            fileIn.close();
//            return models;
//        }catch(IOException i)
//        {
//            i.printStackTrace();
//            return null;
//        }catch(ClassNotFoundException c)
//        {
//            System.out.println("class not found");
//            c.printStackTrace();
//            return null;
//        }
//
//    }
}
