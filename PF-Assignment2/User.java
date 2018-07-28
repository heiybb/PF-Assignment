package PF.Assignment2;

import java.util.ArrayList;

public class User {
    protected String usrName;
    private String usrID;
    private String usrNum;
    private double usrBalance;
    private OS usrOS;
    private boolean isPremium;
    private ArrayList<Content> itemsBought;

    public User(String id, String name, String num, int balance, OS os) {
        this.usrID = id;
        this.usrName = name;
        this.usrNum = num;
        this.usrBalance = balance;
        this.usrOS = os;
        this.isPremium = false;
        this.itemsBought = new ArrayList<>();
    }

    public User(String cID, String cName, String cNum, OS cOS) {
        this(cID, cName, cNum, 0, cOS);
    }

    public void becomePremium() {
        if (isPremium) {
            System.out.println(this.usrName + " has already been a premium");
        } else {
            try {
                setPremium();
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void buyContent(Content item) {
        String buyErrorMsg = this.usrName + " can not buy " + item;
        double disCount = isPremium ? 0.8 : 1.0;
        try {
            if (item instanceof Game) {
                if (!this.usrOS.nameOS.equals(((Game) item).os.nameOS)) {
                    throw new OsErrorException(buyErrorMsg + " due to OS mismatch");
                } else if (this.usrOS.nameOS.equals(((Game) item).os.nameOS) && (this.usrOS.verOS < ((Game) item).os.verOS)) {
                    throw new OsErrorException(buyErrorMsg + " due to OS version mismatch");
                }
            }

            if (this.usrBalance < (disCount * item.ctPrice)) {
                throw new InsufficientBalanceException(buyErrorMsg + " due to balance insufficient");
            } else {
                this.usrBalance = this.usrBalance - (disCount * item.ctPrice);
                itemsBought.add(item);
                item.downnum++;
                System.out.println(this.usrName + " bought " + item);
            }
        } catch (OsErrorException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    void showContentsBought() {
        System.out.println("The contents bought by " + this.usrName + " are:");
        for (Content item : itemsBought) {
            System.out.println(item);
        }
    }

    private void setPremium() throws InsufficientBalanceException {
        double premiumCost = 100.00;
        if (this.usrBalance < premiumCost) {
            throw new InsufficientBalanceException(this.usrName + " can not become premium due to balance insufficient");
        } else {
            this.usrBalance = this.usrBalance - premiumCost;
            isPremium = true;
            System.out.println(this.usrName + " is now premium user");
        }

    }

    public String getUsrID() {
        return usrID;
    }

    public String getUsrNum() {
        return usrNum;
    }

    /** OsErrorException,InsufficientBalanceException are only used in User Class so set them as private*/
    private class OsErrorException extends Exception {
        private String msg;

        private OsErrorException(String msg) {
            this.msg = msg;
        }

        @Override
        public String getMessage() {
            return msg;
        }
    }

    private class InsufficientBalanceException extends Exception {
        private String msg;

        private InsufficientBalanceException(String msg) {
            this.msg = msg;
        }

        @Override
        public String getMessage() {
            return msg;
        }
    }
}