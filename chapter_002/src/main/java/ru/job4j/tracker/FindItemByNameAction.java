package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by Name ====";
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
