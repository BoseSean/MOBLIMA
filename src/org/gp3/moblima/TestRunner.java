package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.*;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;

import java.util.ArrayList;

public class TestRunner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();

        manager.add(Constant.Tables.ADMIN, new Admin("admin", "admin"));
        manager.add(Constant.Tables.USER, new User("user", "12312312312", "user@email.com"));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall 1", false, new ArrayList<Slot>(), "HON", Constant.Cineplex.JEM, 16, 16));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall 2", false, new ArrayList<Slot>(), "HTW", Constant.Cineplex.JEM, 7, 8));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall 3", false, new ArrayList<Slot>(), "HTH", Constant.Cineplex.JEM, 10, 10));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall A", false, new ArrayList<Slot>(), "HAA", Constant.Cineplex.WEST_MALL, 10, 10));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall B", false, new ArrayList<Slot>(), "HAB", Constant.Cineplex.WEST_MALL, 12, 12));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall C", false, new ArrayList<Slot>(), "HAC", Constant.Cineplex.WEST_MALL, 10, 10));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall JJ", false, new ArrayList<Slot>(), "JON", Constant.Cineplex.CINELEISURE_ORCHARD, 6, 10));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall PG", false, new ArrayList<Slot>(), "PGO", Constant.Cineplex.CINELEISURE_ORCHARD, 10, 10));
        manager.add(Constant.Tables.CINEMA, new Cinema("Hall GA", false, new ArrayList<Slot>(), "GAI", Constant.Cineplex.CINELEISURE_ORCHARD, 14, 12));
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();
        manager.commit();
    }
}
