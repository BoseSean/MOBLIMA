package org.gp3.moblima;

//import javafx.scene.input.Mnemonic;
import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.view.MainMenu;
import org.gp3.moblima.view.MenuLoop;

public class Runner {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        MenuLoop loop = new MenuLoop(new MainMenu(null));
        loop.start();

    }
}
