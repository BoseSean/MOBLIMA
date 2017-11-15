package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;

public class TestRunner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();

        manager.add(Constant.Tables.ADMIN, new Admin("admin", "admin"));
        manager.add(Constant.Tables.USER, new User("user", "12312312312", "user@email.com"));
        manager.add(Constant.Tables.CINEMA, new Cinema("JEM", false, new ArrayList<Slot>(), "JEM", Constant.Cineplex.JEM, 10, 10));
        manager.add(Constant.Tables.CINEMA, new Cinema("West Mall", false, new ArrayList<Slot>(), "WEM", Constant.Cineplex.WEST_MALL, 10, 10));

        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();
        manager.commit();
    }
}
