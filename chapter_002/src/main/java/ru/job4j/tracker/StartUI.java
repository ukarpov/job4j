package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Items ====");
                Item[] items = tracker.findAll();
                for (Item itm : items) {
                    System.out.println(itm.getId() + ": " + itm.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter id: ");
                String itemId = scanner.nextLine();
                Item itm = tracker.findById(itemId);
                if (itm == null) {
                    System.out.println("Item not found!");
                } else {
                    System.out.print("Enter new name: ");
                    itm.setName(scanner.nextLine());
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter id: ");
                String itemId = scanner.nextLine();
                Item itm = tracker.findById(itemId);
                if (itm == null) {
                    System.out.println("Item not found!");
                } else {
                    tracker.delete(itemId);
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by Id ====");
                System.out.print("Enter id: ");
                String itemId = scanner.nextLine();
                Item itm = tracker.findById(itemId);
                System.out.println(itm.getId() + ": " + itm.getName());
            } else if (select == 5) {
                System.out.println("=== Find Items by Name ====");
                System.out.print("Enter name: ");
                String key = scanner.nextLine();
                Item[] items = tracker.findByName(key);
                for (Item itm : items) {
                    System.out.println(itm.getId() + ": " + itm.getName());
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
