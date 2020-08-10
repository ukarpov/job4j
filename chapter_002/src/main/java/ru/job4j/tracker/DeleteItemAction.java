package ru.job4j.tracker;

public class DeleteItemAction extends AbstractAction {

    public DeleteItemAction(int key) {
        super(key, "=== Delete Item ====");
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String itemId = input.askStr("Enter id: ");
        if (!tracker.delete(itemId)) {
            System.out.println("Item not found!");
        }
        return true;
    }
}
