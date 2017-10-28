package org.gp3.moblima.view;

//import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class IOUtil {
    public static int SCREEN_WIDTH = 80;
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
            if (!(c >= min && c <= max)) print("Please enter valid option. ");
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
     * */
    public static boolean confirm(String message) {
        while (true) {
            String in = read(message + " (Y/N): ");
            if (in.equalsIgnoreCase("y"))
                return true;
            else if (in.equalsIgnoreCase("n"))
                return false;
        }
    }

    // TODO deep refinement for readChoice() required.
    public static int readChoice(int min, int max) {
        return readChoice("Choice", min, max);
    }

    public static int readChoice(String message, int min, int max) {
        return readInt(message, min, max);
    }

    public static int readChoice(String message, int choice) {
        return readInt(message, 0, choice);
    }


    public static String read(String message) {
        String input = "";
        print(message);

        do{
            input = sc.nextLine();
        }while(input.trim().equals(""));

        return input;
    }

	public static String readln(String message)
    {
        println(message);
        return sc.nextLine();
    }

    public static void println(String message) {
        System.out.println(message);
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

    public static void printTitle(String title) {
        printSplitLine();
        printCenter(title);
        printSplitLine();

    }

    public static void printMenuItems(ArrayList<String> choices, int choiceIdFrom) {
        for (String choice : choices) {
            println((choiceIdFrom++) + ": " + choice);
			System.out.println();

		}
    }
}
