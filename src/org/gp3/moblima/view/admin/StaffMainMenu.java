package org.gp3.moblima.view.admin;

import org.gp3.moblima.model.Admin;
import org.gp3.moblima.view.BaseMenu;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class StaffMainMenu extends BaseMenu {
    private Admin admin;

    public StaffMainMenu(BaseMenu previousMenu, Admin admin) {
        super(previousMenu);
        this.admin = admin;
    }

    @Override
    public BaseMenu execute() {
        return null;
    }
}
