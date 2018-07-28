package PF.Assignment2;

abstract class Reading extends Content {
    protected String genre;
    protected String publisher;
    protected int num;

    Reading(String id, String name, int price, String publisher, String genre, int num) {
        super(id, name, price);
        this.publisher = publisher;
        this.genre = genre;
        this.num = num;
    }
}