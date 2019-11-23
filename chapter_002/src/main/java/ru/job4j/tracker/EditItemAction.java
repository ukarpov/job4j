package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter id: ");
        Item itm = tracker.findById(itemId);
        if (itm == null) {
            System.out.println("Item not found!");
        } else {
            itm.setName(input.askStr("Enter new name: "));
        }
        return true;
    }
}
