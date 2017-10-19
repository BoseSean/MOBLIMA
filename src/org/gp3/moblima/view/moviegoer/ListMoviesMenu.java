package org.gp3.moblima.view.moviegoer;

import org.gp3.moblima.view.BaseMenu;

import static org.gp3.moblima.view.IOUtil.printTitle;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class ListMoviesMenu extends BaseMenu {

    public ListMoviesMenu(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Movie Listing");
    }
}
