package PF.Assignment2;

public class Game extends Content {
    protected OS os;
    private boolean isMultiPlayer;

    public Game(String id, String name, int price, boolean isMultiPlayer, OS os) {
        super(id, name, price);
        this.isMultiPlayer = isMultiPlayer;
        this.os = os;
    }

    public Game(String id, String name, boolean isMultiPlayer, OS os) {
        this(id, name, 0, isMultiPlayer, os);
    }

    public boolean isMultiPlayer() {
        return isMultiPlayer;
    }

    @Override
    public String toString() {
        return ("Game <" + this.ctName + " for " + this.os.nameOS + ">");
    }
}