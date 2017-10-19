package org.gp3.moblima.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by zhangxinye on 19/10/17.
 */
class IOUtil {
    private static Scanner sc = new Scanner(System.in);


//    public static Date readTime(String message) {
//        do {
//            // TODO correct the following code
//            try {
//                String time = read(message + " (" + Constant.FORMAT_TIME_CLOCK + "): ");
//                return Constant.clockFormat.parse(time);
//            } catch (ParseException ime) {
//                println("Please enter a correct time format");
//                sc.nextLine();
//            }
//        } while (true);
//    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static int readInt(String message, int min, int max) {
        int c = 0;

        do {
                c = readInt(message + " (" + min + "~" + max + "): ");
            println("Please input an Integer value.");
        } while (!(c >= min && c <= max));
        return c;
    }

    public static int readInt(String Message) {
        print(Message);
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
            }
        }
    }

    public static int readChoice(int min, int max) {
        return readChoice("Choice", min, max);
    }

    public static int readChoice(String label, int min, int max) {
        int c = readInt(label, min, max);
    }

    public static void println(String message) {
        System.out.print(message);
    }
}
