package ru.job4j.tracker;

public class EditItemAction extends AbstractAction {

    public EditItemAction(int key) {
        super(key, "=== Edit Item ====");
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String itemId = input.askStr("Enter id: ");
        Item itm = new Item(input.askStr("Enter new name: "));
        if (!tracker.replace(itemId, itm)) {
            System.out.println("Item not found!");
        }
        return true;
    }
}
