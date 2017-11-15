package org.gp3.moblima.view;

import org.gp3.moblima.controller.Manager;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class MenuLoop {
    private BaseMenu entryMenu;
    private boolean autoCommit;

    public MenuLoop(BaseMenu entryMenu, boolean autoCommit) {
        this.entryMenu = entryMenu;
        this.autoCommit = autoCommit;
    }

    public void start() {
        BaseMenu nextMenu = entryMenu;
        if (autoCommit)
            do {
                nextMenu = nextMenu.execute();
                Manager.getInstance().commit();
            } while (!(nextMenu instanceof Quit));
        else
            do {
                nextMenu = nextMenu.execute();
            } while (!(nextMenu instanceof Quit));
    }
}
