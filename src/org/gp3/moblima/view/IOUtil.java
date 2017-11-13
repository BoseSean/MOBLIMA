package org.gp3.moblima.view;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.gp3.moblima.model.Constant.Tables.USER;

//import org.jetbrains.annotations.Contract;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class IOUtil {
    private static Manager manager = Manager.getInstance();

    public static int SCREEN_WIDTH = 80;
    private static Scanner sc = new Scanner(System.in);


    public static void print(String message) {
        System.out.print(message);
    }

    public static void print(int num) {
        System.out.print(num);
    }

    public static int readInt(String message, int min, int max) {
        int c = 0;
        do {
            if(min == max)
                readInt(message + " (" + max + "):");
            else
                c = readInt(message + " (" + min + "~" + max + "): ");
            if (!(c >= min && c <= max))
                print("Please enter valid option. ");
        } while (!(c >= min && c <= max));
        return c;
    }


    public static int readInt(String Message) {
        print(Message);
        while (true) {
            try {
                String s = sc.next();
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                println("Please, input a valid decimal number. ");
            }
        }
    }

    /**
     * Confirmation Message
     * --------------------
     * This method only accept 'y' or 'n' as input
     * return 	 true  if input is 'y' or
     * return 	 false if input is 'n'
     * Otherwise it will repeatedly prompt user for input
     */
    public static boolean confirm(String message) {
        while (true) {
            String in = read(message + " (Y/N): ");
            if (in.equalsIgnoreCase("y"))
                return true;
            else if (in.equalsIgnoreCase("n"))
                return false;
        }
    }


    public static int readChoice(int min, int max) {
        return readChoice("Choice", min, max);
    }

    public static int readChoice(String message, int min, int max) {
        return readInt(message, min, max - 1);
    }

//    public static int readChoice(String message, int choice) {
//        return readInt(message, 0, choice);
//    }


    public static String read(String message) {
        String input = "";
        print(message);

        do {
            input = sc.nextLine();
        } while (input.trim().equals(""));

        return input;
    }

    public static String readln(String message) {
        println(message);
        return sc.nextLine();
    }

    public static void println(String message) {
        StringBuilder builder = new StringBuilder(
                message.length() + "\n  ".length() * (message.length() / SCREEN_WIDTH) + 1);
        int index = 0;
        String prefix = "";
        while (index < message.length()) {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = "\n  ";

            builder.append(message.substring(index,
                    Math.min(index + SCREEN_WIDTH, message.length())));
            index += SCREEN_WIDTH;
        }
        System.out.println(builder.toString());
    }

    public static void println() {
        System.out.println();

    }

    public static void printSplitLine() {
        for (int i = SCREEN_WIDTH; i > 0; i--)
            print("-");
        println();
    }

    public static void printCenter(String s) {
        if (s.length() > SCREEN_WIDTH) {
            println(s.substring(0, SCREEN_WIDTH));
        } else if (s.length() == SCREEN_WIDTH) {
            println(s);
        } else {
            int leftPadding = (SCREEN_WIDTH - s.length()) / 2;
            StringBuilder leftBuilder = new StringBuilder();

            for (int i = 0; i < leftPadding; i++) {
                leftBuilder.append(" ");
            }
            int rightPadding = SCREEN_WIDTH - s.length() - leftPadding;
            StringBuilder rightBuilder = new StringBuilder();
            for (int i = 0; i < rightPadding; i++)
                rightBuilder.append(" ");

            println(leftBuilder.toString() + s
                    + rightBuilder.toString());
        }

    }

    /**
     * This method will only read in a format of the date with label
     *
     * @param label is the message to be printed when asking for input
     * @return Date when a correct format if entered, Otherwise keep prompting
     */
    public static Date readDate(String label) {
        return readDate(label, "");
    }

    public static Date readDate(String label, String format) {
        SimpleDateFormat sdf;

        if (format.isEmpty()) { // default value
            sdf = Constant.dateFormatShort;
            format = Constant.FORMAT_DATE_SHORT;
        } else {
            sdf = new SimpleDateFormat(format);
        }

        do {
            try {
                String date = read(label + " (" + format + "): ");
                return sdf.parse(date);
            } catch (ParseException ime) {
                println("Please enter a correct date format");
                sc.nextLine();
            }
        } while (true);
    }


    /**
     * This method will only read in a format of the time with label
     *
     * @param label is the message to be printed when asking for input
     * @return Date when a correct format if entered, Otherwise keep prompting
     */
    public static Date readTime(String label) {
        do {
            try {
                String time = read(label + " (" + Constant.FORMAT_TIME_CLOCK + "): ");
                return Constant.clockFormat.parse(time);
            } catch (ParseException ime) {
                println("Please enter a correct time format");
                sc.nextLine();
            }
        } while (true);
    }


    public String printDate(Date date) {
        return Constant.holidayFormat.format(date);
    }

    public static void printTitle(String title) {
        printSplitLine();
        printCenter(title);
        printSplitLine();

    }


    public static User login() {
        // Login
        User user = null;
        do {
            String name = read("Name: ");
            String phone = read("Phone number: ");
            user = manager.getEntry(USER, (User u) -> (u.getName().equals(name) && u.getPhone().equals(phone)));
            if (user == null) {
                println("Incorrect username or phone number, please try again.");
            }

        } while (user == null);

        return user;
    }

    //todo new opening time need to strict to time string only.

    public static void printMenuItems(ArrayList<String> choices, int choiceIdFrom) {
        for (String choice : choices) {
            println((choiceIdFrom++) + ": " + choice);
            System.out.println();
        }
    }
    }
