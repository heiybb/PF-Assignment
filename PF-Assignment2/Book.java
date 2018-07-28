package PF.Assignment2;

public class Book extends Reading {
    protected String[] bkAuthor;

    public Book(String id, String name, int price, String publisher, String genre, int num, String[] authors) {
        super(id, name, price, publisher, genre, num);
        this.bkAuthor = authors;
    }

    public Book(String id, String name, String publisher, String genre, int num, String[] authors) {
        this(id, name, 0, publisher, genre, num, authors);
    }

    @Override
    public String toString() {
        return ("Book <" + this.ctName + ">");
    }
}