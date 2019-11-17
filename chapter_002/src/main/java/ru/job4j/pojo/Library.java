package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book kolobok = new Book("Kolobok", 7);
        Book shildt = new Book("Java Shildt", 1000);
        Book harryP = new Book("Harry Potter", 500);
        Book cleanCode = new Book("Clean Code", 1000);

        Book[] books = new Book[4];
        books[0] = kolobok;
        books[1] = shildt;
        books[2] = harryP;
        books[3] = cleanCode;

        System.out.println("Books:");
        for (Book b : books) {
            System.out.println("Book " + b.getName() + " has " + b.getPages() + " pages ");
        }

        Book t = books[0];
        books[0] = books[3];
        books[3] = t;
        System.out.println();
        System.out.println("After books change:");
        for (Book b : books) {
            System.out.println("Book " + b.getName() + " has " + b.getPages() + " pages ");
        }

        System.out.println();
        System.out.println("Find Clean code:");
        for (Book b : books) {
            if (b.getName().equals("Clean Code")) {
                System.out.println("Book " + b.getName() + " has " + b.getPages() + " pages ");
                break;
            }
        }
    }
}
