package org.gp3.moblima;

//import javafx.scene.input.Mnemonic;
import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;
import org.gp3.moblima.model.Constant;
import org.gp3.moblima.model.Admin;
import org.gp3.moblima.model.Cinema;
import org.gp3.moblima.model.Slot;

import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        manager.add(Constant.Tables.ADMIN, new Admin("admin", "admin"));
        manager.add(Constant.Tables.CINEMA, new Cinema("JEM",false, new ArrayList<Slot>()));
        manager.add(Constant.Tables.CINEMA, new Cinema("West Mall",false, new ArrayList<Slot>()));
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();

        manager.commit();

    }
}
