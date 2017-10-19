package org.gp3.moblima.view;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class MenuLoop {
    private BaseMenu entryMenu;

    public MenuLoop(BaseMenu entryMenu) {
        this.entryMenu = entryMenu;
    }

    public void start() {
        BaseMenu nextMenu = entryMenu;
        do {
            nextMenu = nextMenu.execute();
        } while (!(nextMenu instanceof Quit));
    }
}
