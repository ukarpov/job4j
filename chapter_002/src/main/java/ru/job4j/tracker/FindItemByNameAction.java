package ru.job4j.tracker;

public class FindItemByNameAction extends AbstractAction {

    public FindItemByNameAction(int key) {
        super(key, "=== Find Items by Name ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String key = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(key);
        for (Item itm : items) {
            System.out.println(itm.getId() + ": " + itm.getName());
        }
        return true;
    }
}
