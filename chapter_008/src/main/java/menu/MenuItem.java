package menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Action {

    private final String name;
    private final List<MenuItem> submenu;
    private Action action;

    public MenuItem(String name) {
        this.name = name;
        this.submenu = new ArrayList<>();
    }

    public void addSubmenu(MenuItem m) {
        submenu.add(m);
    }

    public void setAction(Action a) {
        this.action = a;
    }

    public void printMenu(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < level; i++) {
            sb.append("--");
        }
        System.out.println(sb.append(this.name).toString());
        submenu.forEach(m -> m.printMenu(level + 1));
    }

    @Override
    public void doAction() {
        action.doAction();
    }

    public static void main(String[] args) {
        MenuItem mir = new MenuItem("");
        MenuItem mi1 = new MenuItem("Action 1");
        MenuItem mi11 = new MenuItem("Action 1.1");
        MenuItem mi111 = new MenuItem("Action 1.1.1");
        MenuItem mi112 = new MenuItem("Action 1.1.2");
        MenuItem mi12 = new MenuItem("Action 1.2");
        MenuItem mi2 = new MenuItem("Action 2");
        MenuItem mi21 = new MenuItem("Action 2.1");

        mi11.addSubmenu(mi111);
        mi11.addSubmenu(mi112);
        mi1.addSubmenu(mi11);
        mi1.addSubmenu(mi12);
        mi2.addSubmenu(mi21);
        mir.addSubmenu(mi1);
        mir.addSubmenu(mi2);

        mir.printMenu(0);
    }
}
