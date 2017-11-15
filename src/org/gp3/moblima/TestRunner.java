package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.controller.PriceManager;
import org.gp3.moblima.model.*;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.println;

public class TestRunner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        PriceManager om = PriceManager.getInstance();
        //manager.add(Constant.Tables.ADMIN, new Admin("admin", "admin"));
        //manager.add(Constant.Tables.MOVIE, new Movie(""));
        //manager.add(Constant.Tables.USER, new User("user", "12312312312", "user@email.com"));
       // manager.add(Constant.Tables.CINEMA, new Cinema("JEM", false, new ArrayList<Slot>(), "JEM",Constant.Cineplex.JEM,10,10));
       // manager.add(Constant.Tables.CINEMA, new Cinema("West Mall", false, new ArrayList<Slot>(), "WEM",Constant.Cineplex.WEST_MALL,10, 10));
        PriceManager pm = PriceManager.getInstance();
        //String s = "Suburbicon is a peaceful, idyllic suburban community with affordable homes and manicured lawns…the perfect place to raise a family, and in the summer of 1959, the Lodge family is doing just that. But the tranquil surface masks a disturbing reality, as husband and father Gardner Lodge (Matt Damon) must navigate the town’s dark underbelly of betrayal, deceit, and violence. This is a tale of very flawed people making very bad choices. This is Suburbicon.";
        //println(s);
        //manager.add(Constant.Tables.MOVIE, new Movie("Matrix"));
        //manager.add(Constant.Tables.MOVIE, new Movie(""));
        //manager.add(Constant.Tables.USER, new User("user", "12312312312", "user@email.com"));
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();
        manager.commit();
    }

//    private static int SCREEN_WIDTH = 80;
//    public static void println(String message) {
//        StringBuilder builder = new StringBuilder();
//////                message.length() + "\n  ".length() * (message.length()/SCREEN_WIDTH)+1);
////        int index = 0;
////        String prefix = "";
////        while (index < message.length())
////        {
////            builder.append(prefix);
////            if(message.charAt(index) !=  ' ') prefix = "-\n  ";
////            else prefix = "\n  ";
////            builder.append(message.substring(index, Math.min(index + SCREEN_WIDTH, message.length()) ));
////            index += SCREEN_WIDTH;
////        }
////        index = 0;
////        builder.append(message.substring(index, Math.min(index + SCREEN_WIDTH, message.length()) ));
//        int i;
//        for(i=0; i< message.length()/SCREEN_WIDTH; i++ ){
//            builder.append(message.substring(i*SCREEN_WIDTH, (i+1)*SCREEN_WIDTH));
//            System.out.println(message.charAt(i*SCREEN_WIDTH));
//            if(message.charAt(i*SCREEN_WIDTH - 1) !=  ' ') {
//                builder.append("-\n  ");
//            }
//            else {
//                builder.append("\n  ");
//            }
//        }
//        builder.append(message.substring(i*SCREEN_WIDTH, message.length()));
//        System.out.println(builder.toString());
//    }
}
