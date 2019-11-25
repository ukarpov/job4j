package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter id: ");
        if (!tracker.delete(itemId)) {
            System.out.println("Item not found!");
        }
        return true;
    }
}
