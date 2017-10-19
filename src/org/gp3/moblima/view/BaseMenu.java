package org.gp3.moblima.view;


/**
 * created by hannancao on 15/10/17.
 */
public abstract class BaseMenu {
    private BaseMenu previousMenu;

    public BaseMenu(BaseMenu previousMenu) {
        this.previousMenu = previousMenu;
    }

    public abstract BaseMenu execute();

    protected BaseMenu previousMenu() {
        if (previousMenu != null)
            return previousMenu;
        else
            return this;
    }
}
