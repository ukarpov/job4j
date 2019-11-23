package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all Items ====");
        Item[] items = tracker.findAll();
        for (Item itm : items) {
            System.out.println(itm.getId() + ": " + itm.getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        String itemId = input.askStr("Enter id: ");
        Item itm = tracker.findById(itemId);
        if (itm == null) {
            System.out.println("Item not found!");
        } else {
            itm.setName(input.askStr("Enter new name: "));
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        String itemId = input.askStr("Enter id: ");
        Item itm = tracker.findById(itemId);
        if (itm == null) {
            System.out.println("Item not found!");
        } else {
            tracker.delete(itemId);
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        String itemId = input.askStr("Enter id: ");
        Item itm = tracker.findById(itemId);
        if (itm == null) {
            System.out.println("Item not found!");
        } else {
            System.out.println(itm.getId() + ": " + itm.getName());
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find Items by Name ====");
        String key = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(key);
        for (Item itm : items) {
            System.out.println(itm.getId() + ": " + itm.getName());
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.print("0. Add new Item\n"
                       + "1. Show all items\n"
                       + "2. Edit item\n"
                       + "3. Delete item\n"
                       + "4. Find item by Id\n"
                       + "5. Find items by name\n"
                       + "6. Exit Program\n");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
