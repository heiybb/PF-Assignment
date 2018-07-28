package PF.Assignment2;

public class Magazine extends Reading {
    protected String mgTitle;

    public Magazine(String cID, String cName, int cPrice, String cPublisher, String cGenre, int cNum, String cmgTitle) {
        super(cID, cName, cPrice, cPublisher, cGenre, cNum);
        this.mgTitle = cmgTitle;
    }

    public Magazine(String cID, String cName, String cPublisher, String cGenre, int cNum, String cmgTitle) {
        this(cID, cName, 0, cPublisher, cGenre, cNum, cmgTitle);
    }

    @Override
    public String toString() {
        return ("Magazine <" + this.ctName + ">");
    }
}