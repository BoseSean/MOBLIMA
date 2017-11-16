package org.gp3.moblima.view;


/**
 * The base class for all the Menus
 */
public abstract class BaseMenu {
    private BaseMenu previousMenu;

    public BaseMenu(BaseMenu previousMenu) {
        this.previousMenu = previousMenu;
    }

    /**
     * On start of a menu, this method will be called
     *
     * @return next menu to be displayed
     */
    public abstract BaseMenu execute();

    protected BaseMenu getPreviousMenu() {
        if (previousMenu != null)
            return previousMenu;
        else
            return this;
    }
}
