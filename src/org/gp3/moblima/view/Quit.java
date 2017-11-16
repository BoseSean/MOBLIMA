package org.gp3.moblima.view;

/**
 * Special menu representing termination of the program
 */
public class Quit extends BaseMenu {
    public Quit(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        return null;
    }
}
