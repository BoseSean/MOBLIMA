package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.*;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;

import java.util.ArrayList;

public class TestRunner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
       // manager.add(Constant.Tables.ADMIN, new Admin("admin", "admin"));
//        manager.add(Constant.Tables.MOVIE, new Movie("Matrix"));

        // manager.add(Constant.Tables.MOVIE, new Movie(""));
        //manager.add(Constant.Tables.USER, new User("user", "12312312312", "user@email.com"));
        //manager.add(Constant.Tables.CINEMA, new Cinema("JEM", false, new ArrayList<Slot>(), Constant.Cineplex.JEM));
        //manager.add(Constant.Tables.CINEMA, new Cinema("West Mall", false, new ArrayList<Slot>(), Constant.Cineplex.WEST_MALL));
        // System.out.println(pm.getPrice(Constant.TicketType.MON_THU, Constant.MovieType.TWO_D_AND_WESTMALL, true, true));
        //PriceManager pm = PriceManager.getInstance();
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();
        manager.commit();
    }
}