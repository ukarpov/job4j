package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter id: ");
        Item itm = new Item(input.askStr("Enter new name: "));
        if (!tracker.replace(itemId, itm)) {
            System.out.println("Item not found!");
        }
        return true;
    }
}
