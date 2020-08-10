package ru.job4j.tracker;

public class FindItemByIdAction extends AbstractAction {

    public FindItemByIdAction(int key) {
        super(key, "=== Find Item by Id ====");
    }

    @Override
    public boolean execute(Input input, Store tracker) {
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
