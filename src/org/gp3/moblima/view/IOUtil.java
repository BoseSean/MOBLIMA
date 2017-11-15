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
        String s;
        do {
            s = sc.nextLine();
        }
        while (s.equals(""));
        return s;
    }

    public static void println(String message) {
        println(message, 0);
    }

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

    public static void println(String message, int indentedBy) {
        println(message, " ", indentedBy);
//        StringBuilder builder = new StringBuilder();
//        int index = 0;
//        StringBuilder prefix = new StringBuilder();
//        prefix.append("");
//        while (index < message.length()) {
//            builder.append(prefix);
//            prefix.replace(0, prefix.length(), "\n");
//            for(int i=0; i<indentedBy; i++)
//                prefix.append(" ");
//            builder.append(message.substring(index,
//                    Math.min(index + SCREEN_WIDTH-indentedBy, message.length())));
//            index += SCREEN_WIDTH-indentedBy;
//        }
//        System.out.println(builder.toString());
    }

    public static void println() {
        System.out.println();

    }

    public static void printSplitLine() {
        for (int i = SCREEN_WIDTH; i > 0; i--)
            print("-");
        println();
    }

    public static void printf(int value) {
        System.out.printf("%-3d", value);
    }

    //    public static void printf_two(int value) {
//        System.out.printf("%-4d", value);
//    }
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
                String[] split = date.split("/");
                if (((Integer.parseInt(split[1]) < 13 && Integer.parseInt(split[1]) > 0) && (Integer.parseInt(split[0]) < 32 && Integer.parseInt(split[0]) > 0))) {
                    return sdf.parse(date);
                } else {
                    throw new ParseException("Please enter a correct date", 0);
                }
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
                if (((Integer.parseInt(split[0]) < 23 && Integer.parseInt(split[0]) > 0) && (Integer.parseInt(split[1]) < 59 && Integer.parseInt(split[1]) > 0))) {
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


    public static void printMenuItems(ArrayList<String> choices, int choiceIdFrom) {
        for (String choice : choices) {
            println((choiceIdFrom++) + ": " + choice);
            System.out.println();
        }
    }
    }
