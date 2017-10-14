package org.gp3.moblima.model;

import java.io.*;

public class SerializeModel<T>
{
    public static void writeSerial(T model)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream("123.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(model);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    public static T readSerial()
    {
        Model model = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("123.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            model = (Model) in.readObject();
            in.close();
            fileIn.close();
            return (T)model;
        }catch(IOException i)
        {
            i.printStackTrace();
            return (T)null;
        }catch(ClassNotFoundException c)
        {
            System.out.println("class not found");
            c.printStackTrace();
            return null;
        }

    }
}
