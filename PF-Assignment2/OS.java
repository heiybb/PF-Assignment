package PF.Assignment2;

public class OS {

    public OS(String cnameOS, int cverOS) {
        nameOS = cnameOS;
        verOS = cverOS;
    }

    public String getNameOS() {
        return nameOS;
    }

    public int getVerOS() {
        return verOS;
    }

    protected String nameOS;
    protected int verOS;
}
