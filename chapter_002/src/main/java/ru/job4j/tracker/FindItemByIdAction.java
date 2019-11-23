package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter id: ");
        Item itm = tracker.findById(itemId);
        if (itm == null) {
            System.out.println("Item not found!");
        } else {
            System.out.println(itm.getId() + ": " + itm.getName());
        }
        return true;
    }
}
