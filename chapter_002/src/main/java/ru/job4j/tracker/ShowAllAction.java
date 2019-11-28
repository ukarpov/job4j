package ru.job4j.tracker;

public class ShowAllAction extends AbstractAction {

    public ShowAllAction(int key) {
        super(key, "=== Show all Items ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item itm : items) {
            System.out.println(itm.getId() + ": " + itm.getName());
        }
        return true;
    }
}
