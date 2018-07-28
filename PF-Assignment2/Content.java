package PF.Assignment2;

import java.util.ArrayList;
import java.util.List;

abstract class Content {
    protected String ctID;
    protected String ctName;
    protected double ctPrice;
    protected int downnum;
    private ArrayList<Comment> review;

    Content(String id, String name, int price) {
        this.ctID = id;
        this.ctName = name;
        this.ctPrice = price;
        this.review = new ArrayList<>();
    }

    public void addReviews(Comment cmt) {
        review.add(cmt);
        System.out.println(cmt.usr.usrName + " added review " + '"' + cmt.usrComment + '"' + " on " + this);
    }

    public void printAllReview() {
        System.out.println("The reviews of " + this + " are:");
        for (Comment e : review) {
            System.out.println(e.getUserNameID() + ":" + e.usrComment);
            queryCmt(e, 1);
        }
    }

    /** generate space to beautify the output*/
    private String generateSpace(int count) {
        count = count * 4;
        char[] chs = new char[count];
        for (int i = 0; i < count; i++) {
            chs[i] = ' ';
        }
        return new String(chs);
    }

    /** query all the comments include the childNode*/
    private void queryCmt(Comment acmt, int depth) {
        List<Comment> sonList = acmt.childNode;
        String space = generateSpace(depth);

        if (sonList == null || sonList.isEmpty()) {
            return;
        }

        for (int i = 0; i < sonList.size(); i++) {
            System.out.println(space + sonList.get(i).getUserNameID() + ":" + sonList.get(i).getUsrComment());
            if (i == 0) {
                depth = depth + 1;
            }
            queryCmt(sonList.get(i), depth);
        }
    }
}