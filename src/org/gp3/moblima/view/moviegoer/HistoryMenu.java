package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.view.BaseMenu;
import org.gp3.moblima.model.User;

import java.util.ArrayList;

import static org.gp3.moblima.view.IOUtil.printTitle;
import static org.gp3.moblima.view.IOUtil.println;
import static org.gp3.moblima.view.IOUtil.read;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class HistoryMenu extends BaseMenu {


    public HistoryMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("History");

		Manager manager = Manager.getInstance();
		ArrayList<User> userTable = manager.getAll("USER");

        println("Please login");
		String username = read("Username: ");
		return null;
    }
}
