package org.gp3.moblima;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Admin;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Movie;
import org.gp3.moblima.model.User;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;

public class TestRunner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();

        manager.add(Constant.Tables.ADMIN, new Admin("admin", "admin"));
        manager.add(Constant.Tables.MOVIE, new Movie("Matrix"));
        manager.add(Constant.Tables.MOVIE, new Movie("Matrix2"));
        manager.add(Constant.Tables.USER, new User("user", "12312312312", "user@email.com"));
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();

    }
}
