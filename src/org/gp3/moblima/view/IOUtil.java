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


/**
 * Created by zhangxinye on 19/10/17.
 */
public class IOUtil {
    private static Manager manager = Manager.getInstance();

    public static int SCREEN_WIDTH = 80;
    private static Scanner sc = new Scanner(System.in);


    /**
     * Print Message
     * @param message message to be display
     */
    public static void print(String message) {
        System.out.print(message);
    }

    /**
     * Print Number
     * @param num number to be diplay
     */
    public static void print(int num) {
        System.out.print(num);
    }

    /**
     * method to notify user the allowable range of input
     * @param message Message to be display to notify user about input
     * @param min lower bound
     * @param max upper bound
     * @return the correct input
     */
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

    /**
     * Method to check the validate input of integer
     * @param Message
     * @return validate integer otherwise NumberFormatException
     */
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


    /**
     * Method to notify user the range of allowable range of choice
     * @param min lower bound
     * @param max upper bound
     * @return validate choice otherwise Exception
     */
    public static int readChoice(int min, int max) {
        return readChoice("Choice", min, max);
    }

    /**
     * Method to notify user about the input
     * as well as the allowable range of input
     * @param message input information
     * @param min lower bound
     * @param max upper bound
     * @return validate choice otherwise Exception
     */
    public static int readChoice(String message, int min, int max) {
        return readInt(message, min, max - 1);
    }


    /**
     * Method to notify user about the input String
     * @param message info about input
     * @return validate String otherwise Exception
     */
    public static String read(String message) {
        String input = "";
        print(message);

        do {
            input = sc.nextLine();
        } while (input.trim().equals(""));

        return input;
    }

    /**
     * Method to notify user about the input String line
     * @param message info about input
     * @return validate line otherwise Exception
     */
    public static String readln(String message) {
        println(message);
        String s;
        do {
            s = sc.nextLine();
        }
        while (s.equals(""));
        return s;
    }

    /**
     * Method print a line
     * @param message info about input
     * @return validate line otherwise Exception
     */
    public static void println(String message) {
        println(message, 0);
    }

    /**
     * Method to print multiple line with padding
     * and split by delimiter
     * @param message lines to be printed
     * @param deli split by delimiter
     * @param indentBy padding number
     */
    public static void println(String message, String deli, int indentBy) {
        String[] newMessage = message.split(deli);
        int counter = 0;
        StringBuilder prefix = new StringBuilder();
        prefix.append("\n");
        for(int i=0; i< indentBy; i++) {
            prefix.append(" ");
        }
        for (String msg : newMessage) {
            counter = counter + msg.length();
            if (counter >= SCREEN_WIDTH - indentBy) {
                System.out.print(prefix.toString());
                System.out.print(msg + " ");
                counter = 0;
                counter = counter + msg.length() + 1;
            } else {
                System.out.print(msg + " ");
                counter++;
            }
        }
        println();
    }

    /**
     * Method to print multiple line with padding
     * @param message lines to be printed
     * @param indentedBy padding number
     */
    public static void println(String message, int indentedBy) {
        println(message, " ", indentedBy);
    }

    /**
     * Print a newline
     */
    public static void println() {
        System.out.println();

    }

    // TODO javadoc
    public static void printSplitLine() {
        for (int i = SCREEN_WIDTH; i > 0; i--)
            print("-");
        println();
    }

    // TODO javadoc
    public static void printf(int value) {
        System.out.printf("%-3d", value);
    }

    // TODO javadoc
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
     * wrapper of readDate(String label, String format)
     * @param label is the message to be printed when asking for input
     * @return Date when a correct format if entered, Otherwise keep prompting
     */
    public static Date readDate(String label) {
        return readDate(label, "");
    }

    /**
     * This method will only read in a format of the date with label
     *
     * @param label is the message to be printed when asking for input
     * @param format format of date datatype refer to Constant
     * @return Date when a correct format if entered, Otherwise keep prompting
     */
    public static Date readDate(String label, String format) {
        SimpleDateFormat sdf;

        if (format.isEmpty()) { // default value
            sdf = Constant.dateFormatShort;
            format = Constant.FORMAT_DATE_SHORT;
        } else {
            sdf = new SimpleDateFormat(format);
        }
        sdf.setLenient(false);
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
                String[] split = time.split(":");
                if (((Integer.parseInt(split[0]) < 23 && Integer.parseInt(split[0]) > 0) && (Integer.parseInt(split[1]) < 59 && Integer.parseInt(split[1]) >= 0))) {
                    return Constant.clockFormat.parse(time);
                } else {
                    throw new ParseException("Please enter a correct time", 0);
                }
            } catch (ParseException ime) {
                println("Please enter a correct time format");
                sc.nextLine();
            }
        } while (true);
    }


    /**
     * print a holiday format date
     * refer to Constant
     * @param date
     * @return a holiday formatted date
     */
    public String printDate(Date date) {
        return Constant.holidayFormat.format(date);
    }

    // TODO javadoc
    public static void printTitle(String title) {
        printSplitLine();
        printCenter(title);
        printSplitLine();

    }


    /**
     * request user for username and phonenumber
     * to verify a user
     * @return true if user exists otherwise false
     */
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


    // TODO javadoc
    public static void printMenuItems(ArrayList<String> choices, int choiceIdFrom) {
        for (String choice : choices) {
            println((choiceIdFrom++) + ": " + choice);
            System.out.println();
        }
    }
    }
