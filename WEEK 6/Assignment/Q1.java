class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " " + copiesAvailable + " copies available");
    }
}

public class LibraryInventoryManagement {
    public static void main(String[] args) {
        BookInventory b1 = new BookInventory("Clean Code", "Robert C. Martin", 3);
        BookInventory b2 = new BookInventory("Effective Java", "Joshua Bloch", 5);
        BookInventory b3 = new BookInventory("Refactoring", "Martin Fowler", 0);
        BookInventory b4 = new BookInventory("Design Patterns", "GoF", 2);

        BookInventory[] inventory = {b1, b2, b3, b4};

        for (BookInventory b : inventory) {
            b.printEntry();
        }
    }
}