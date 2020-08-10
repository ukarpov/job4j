package ru.job4j.tracker;

public class CreateAction extends AbstractAction {

    public CreateAction(int key) {
        super(key, "=== Create a new Item ====");
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
