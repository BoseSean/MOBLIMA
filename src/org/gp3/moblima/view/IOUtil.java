package org.gp3.moblima.view;

import org.gp3.moblima.model.Constant;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class IOUtil {
    private static Scanner sc = new Scanner(System.in);

    public static int readInt(String Message) {
        print(Message);
        return sc.nextInt();
    } while(!(c >=min &&c <=max));

        return c;
}

    public static Date readTime(String message) {
        do {
            // TODO correct the following code
            try {
                String time = read(message + " (" + Constant.FORMAT_TIME_CLOCK + "): ");
                return Constant.clockFormat.parse(time);
            } catch (ParseException ime) {
                println("Please enter a correct time format");
                sc.nextLine();
            }
        } while (true);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    protected int readInt(String message, int min, int max) {
        int c = 0;

        do {
            try {
                c = readInt(message + " (" + min + "~" + max + "): ");
            }
            println("Please input an Integer value.");
        }
    }

    public int readChoice(int min, int max) {
        return readChoice("Choice", min, max);
    }

    protected int readChoice(String label, int min, int max) {
        int c = readInt(label, min, max);
    }

    public void println(String message) {
        System.out.print(message);
    }
}
