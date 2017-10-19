package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.view.BaseMenu;

import static org.gp3.moblima.view.IOUtil.printTitle;
import static org.gp3.moblima.view.IOUtil.println;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class HistoryMenu extends BaseMenu {


    public HistoryMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Historys");

        println("Please login");
    }
}
